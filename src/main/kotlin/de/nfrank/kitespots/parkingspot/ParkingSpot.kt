package de.nfrank.kitespots.parkingspot

import de.nfrank.kitespots.common.Location

data class ParkingSpot(
    val location: Location,
    val description: String,
    val campingAllowed: Boolean,
)
