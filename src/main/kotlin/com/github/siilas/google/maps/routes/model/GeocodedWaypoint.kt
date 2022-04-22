package com.github.siilas.google.maps.routes.model

data class GeocodedWaypoint(
    val geocoderStatus: GeocodedWaypointStatus,
    val partialMatch: Boolean,
    val placeId: String,
    val types: List<AddressType>
)
