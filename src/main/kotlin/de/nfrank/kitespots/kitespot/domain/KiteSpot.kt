package de.nfrank.kitespots.kitespot.domain

import de.nfrank.kitespots.airport.Airport
import de.nfrank.kitespots.common.Image
import de.nfrank.kitespots.common.Location
import de.nfrank.kitespots.parkingspot.ParkingSpot
import de.nfrank.kitespots.userrating.UserRating
import de.nfrank.kitespots.user.User
import java.time.Instant

data class KiteSpot(
    val id: String,
    val name: String,
    val description: String,
    val images: List<Image>,
    val experienceLevel: ExperienceLevel,
    val disciplines: List<Discipline>,
    val nearestAirports: List<Airport>,
    val location: Location,
    val parkingSpots: List<ParkingSpot>,
    val userRatings: MutableList<UserRating>,
) {
    fun rate(userId: String, score: Float, comment: String?): Boolean {
        return this.userRatings.add(UserRating(userId, score, comment, Instant.now()))
    }
}

enum class ExperienceLevel {
    BEGINNER,
    EXPERIENCED,
    PROFESSIONAL,
}

enum class Discipline {
    WAVE_KITING,
    BIG_AIR,
    FREESTYLE,
}
