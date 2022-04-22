package com.github.siilas.google.maps.routes.model

import java.time.ZonedDateTime

data class TransitDetails(
    val arrivalStop: StopDetails,
    val departureStop: StopDetails,
    val arrivalTime: ZonedDateTime,
    val departureTime: ZonedDateTime,
    val headsign: String,
    val headway: Long,
    val numStops: Int,
    val line: TransitLine
)
