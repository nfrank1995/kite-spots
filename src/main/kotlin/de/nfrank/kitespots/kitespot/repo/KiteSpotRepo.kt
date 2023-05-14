package de.nfrank.kitespots.kitespot.repo

import de.nfrank.kitespots.airport.Airport
import de.nfrank.kitespots.common.Image
import de.nfrank.kitespots.common.Location
import de.nfrank.kitespots.kitespot.domain.Discipline
import de.nfrank.kitespots.kitespot.domain.ExperienceLevel
import de.nfrank.kitespots.kitespot.domain.KiteSpot
import de.nfrank.kitespots.parkingspot.ParkingSpot
import de.nfrank.kitespots.userrating.UserRating
import de.nfrank.kitespots.user.User
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.Period

@Service
class KiteSpotRepo {
    private val kiteSpots = listOf(
        KiteSpot(
            id = "spot001",
            name = "Terifa",
            description = "Great spot at the southern coast of spain. Strong wind and big waves create the perfect conditions for everyone who wants to surf down a wave or loop thru the air.",
            images = listOf(),
            experienceLevel = ExperienceLevel.PROFESSIONAL,
            disciplines = listOf(Discipline.WAVE_KITING, Discipline.BIG_AIR),
            nearestAirports = listOf(
                Airport(
                    name = "Gibraltar Airport",
                    location = Location(latitude = 36.0113f, longitude = -5.6058f),
                ),
                Airport(
                    name = "Jerez Airport",
                    location = Location(latitude = 36.7435f, longitude = -6.0639f),
                ),
            ),
            location = Location(latitude = 36.0277f, longitude = -5.6237f),
            parkingSpots = emptyList(),
            userRatings = mutableListOf(
                UserRating(
                    userId = "user001",
                    score = 4.5f,
                    comment = "Great Spot for kiteloops and big air!!!!!!",
                    createdAt = Instant.now().minus(Period.ofDays(123)),
                ),
            ),
        ),
        KiteSpot(
            id = "spot002",
            name = "Amoudara",
            description = "Nice spot at the northern coast of crete.",
            images = listOf(),
            experienceLevel = ExperienceLevel.EXPERIENCED,
            disciplines = listOf(Discipline.FREESTYLE),
            nearestAirports = listOf(
                Airport(
                    name = "Heraklion Airport",
                    location = Location(latitude = 35.3370f, longitude = 25.1814f),
                ),
            ),
            location = Location(latitude = 35.33932f, longitude = 25.06386f),
            parkingSpots = listOf(
                ParkingSpot(
                    location = Location(latitude = 35.33932f, longitude = 25.06386f),
                    description = "Free parking spot at the beach.",
                    campingAllowed = true,
                ),
            ),
            userRatings = mutableListOf(
                UserRating(
                    userId = "user002",
                    score = 3.0f,
                    comment = "The spot is okay, sadly the winds aren't strong enough for kiteloops and the water is a little bit cold coming from the river.",
                    createdAt = Instant.now().minus(Period.ofDays(523)),
                ),
            ),
        ),
        KiteSpot(
            id = "Spot003",
            name = "Rhodes",
            description = "Sweet spot with a kite school. The waves make it a little bit hard for beginners but everyone else will enjoy their trip.",
            images = listOf(
                Image(url = "https://kitesurfing-rhode.com/image", description = "Kitesurfing station ath the rhodes beach."),
            ),
            experienceLevel = ExperienceLevel.BEGINNER,
            disciplines = listOf(Discipline.FREESTYLE),
            nearestAirports = listOf(
                Airport(
                    name = "Rhodos Airport",
                    location = Location(latitude = 36.4046f, longitude = 28.0874f),
                ),
            ),
            location = Location(latitude = 36.38770f, longitude = 28.03593f),
            parkingSpots = emptyList(),
            userRatings = mutableListOf(
                UserRating(
                    userId = "userXXX",
                    score = 1.5f,
                    comment = "Went there to learn kitesurfing. The guys at the station are great but the waves made it way to hard to learn. Wouldn't recomment.",
                    createdAt = Instant.now().minus(Period.ofDays(243)),
                ),
            ),
        ),
    )

    fun getKiteSpot(id: String) = kiteSpots.find { it.id == id }
    fun getTopKiteSpots(count: Int?, offset: Int) =
        kiteSpots.sortedByDescending { it.userRatings.sumOf { it.score.toDouble() } / it.userRatings.size }.subList(
            offset,
            offset + (count ?: (kiteSpots.size - 1 - offset)),
        )
    fun getAll() = kiteSpots
    fun rateSpot(spotId: String, userId: String, score: Float, comment: String?): Boolean {
        return this.kiteSpots.find { it.id == spotId }?.rate(userId, score, comment) ?: false
    }
}
