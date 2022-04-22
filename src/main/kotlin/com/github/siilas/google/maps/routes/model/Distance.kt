package com.github.siilas.google.maps.routes.model

data class Distance(
    val originAddresses: List<String>?,
    val destinationAddresses: List<String>?,
    val rows: List<DistanceRow>?
)
