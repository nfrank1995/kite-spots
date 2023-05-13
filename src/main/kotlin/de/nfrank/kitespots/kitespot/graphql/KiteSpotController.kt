package de.nfrank.kitespots.kitespot.graphql

import de.nfrank.kitespots.kitespot.repo.KiteSpotRepo
import de.nfrank.kitespots.userrating.user.User
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class KiteSpotController(
    val kiteSpotRepo: KiteSpotRepo,
) {
    @QueryMapping
    fun kiteSpotOverview() = kiteSpotRepo.getAll()

    @QueryMapping
    fun topKiteSpots(@Argument count: Int?, @Argument offset: Int = 0) = kiteSpotRepo.getTopKiteSpots(count, offset)

    @QueryMapping
    fun kiteSpot(@Argument id: String) = kiteSpotRepo.getKiteSpot(id)

    @MutationMapping
    fun rateSpot(@Argument spotId: String, @Argument userName: String, @Argument userEMail: String, @Argument score: Float, @Argument comment: String?) =
        kiteSpotRepo.rateSpot(spotId, User(userName, userEMail), score, comment)
}
