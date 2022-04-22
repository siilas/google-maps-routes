package com.github.siilas.google.maps.routes.service

import com.github.siilas.google.maps.routes.client.GoogleMapsClient
import com.github.siilas.google.maps.routes.model.Route

class RouteService(
    private val googleMapsClient: GoogleMapsClient
) {

    suspend fun getRoute(origin: String, destination: String): Route {
        return googleMapsClient.getRoute(origin, destination)
    }
}
