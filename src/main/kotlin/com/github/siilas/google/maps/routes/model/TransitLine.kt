package com.github.siilas.google.maps.routes.model

data class TransitLine(
    val name: String,
    val shortName: String,
    val color: String,
    val agencies: List<TransitAgency>,
    val url: String,
    val icon: String,
    val textColor: String,
    val vehicle: Vehicle
)
