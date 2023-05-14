package de.nfrank.kitespots.kitespot.graphql

import de.nfrank.kitespots.kitespot.repo.KiteSpotRepo
import de.nfrank.kitespots.user.UserRepo
import de.nfrank.kitespots.userrating.UserRating
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class KiteSpotController(
    val kiteSpotRepo: KiteSpotRepo,
    val userRepo: UserRepo,
) {
    @QueryMapping
    fun kiteSpotOverview() = kiteSpotRepo.getAll()

    @QueryMapping
    fun topKiteSpots(@Argument count: Int?, @Argument offset: Int?) =
        kiteSpotRepo.getTopKiteSpots(count, offset ?: 0)

    @QueryMapping
    fun kiteSpot(@Argument id: String) = kiteSpotRepo.getKiteSpot(id)

    @MutationMapping
    fun rateSpot(@Argument spotId: String, @Argument userId: String, @Argument score: Float, @Argument comment: String?) =
        kiteSpotRepo.rateSpot(spotId, userId, score, comment)

    @SchemaMapping(typeName = "UserRating", field = "user")
    fun getUser(userRating: UserRating) = userRepo.getById(userRating.userId)
}
