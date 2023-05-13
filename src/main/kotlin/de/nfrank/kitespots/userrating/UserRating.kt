package de.nfrank.kitespots.userrating

import de.nfrank.kitespots.userrating.user.User
import java.time.Instant

data class UserRating(
    val user: User,
    val score: Float,
    val comment: String?,
    val createdAt: Instant,
)
