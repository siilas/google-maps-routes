package com.github.siilas.google.maps.routes.model

import java.time.ZonedDateTime

data class DirectionsLeg(
    val steps: List<DirectionsStep>,
    val distance: Distance,
    val duration: Duration,
    val durationInTraffic: Duration,
    val arrivalTime: ZonedDateTime,
    val departureTime: ZonedDateTime,
    val startLocation: LatLng,
    val endLocation: LatLng,
    val startAddress: String,
    val endAddress: String
)
