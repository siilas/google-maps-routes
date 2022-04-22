package com.github.siilas.google.maps.routes.model

data class DirectionsStep(
    val htmlInstructions: String,
    val distance: Distance,
    val maneuver: String,
    val duration: Duration,
    val startLocation: LatLng,
    val endLocation: LatLng,
    val steps: List<DirectionsStep>,
    val polyline: EncodedPolyline,
    val travelMode: TravelMode,
    val transitDetails: TransitDetails
)
