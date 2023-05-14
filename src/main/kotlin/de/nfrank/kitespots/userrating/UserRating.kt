package de.nfrank.kitespots.userrating

import java.time.Instant

data class UserRating(
    val userId: String,
    val score: Float,
    val comment: String?,
    val createdAt: Instant,
)
