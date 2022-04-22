package com.github.siilas.google.maps.routes.model

data class DirectionsRoute(
    val summary: String,
    val legs: List<DirectionsLeg>,
    val waypointOrder: List<Int>,
    val overviewPolyline: EncodedPolyline,
    val bounds: Bounds,
    val copyrights: String,
    val fare: Fare,
    val warnings: List<String>
)
