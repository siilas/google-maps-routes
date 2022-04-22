package com.github.siilas.google.maps.routes.service

import com.github.siilas.google.maps.routes.client.GoogleMapsClient
import com.github.siilas.google.maps.routes.model.Distance

class DistanceService(
    private val googleMapsClient: GoogleMapsClient
) {

    suspend fun getDistance(origins: String, destinations: String): Distance {
        return googleMapsClient.getDistance(origins, destinations)
    }
}
