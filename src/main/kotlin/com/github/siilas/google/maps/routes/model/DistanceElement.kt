package com.github.siilas.google.maps.routes.model

data class DistanceElement(
    val status: DistanceElementStatus,
    val duration: Duration,
    val durationInTraffic: Duration,
    val distance: Distance,
    val fare: Fare
)
