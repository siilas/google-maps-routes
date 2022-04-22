package com.github.siilas.google.maps.routes.model

data class Route(
    val geocodedWaypoints: List<GeocodedWaypoint>?,
    val routes: List<DirectionsRoute>?
)
