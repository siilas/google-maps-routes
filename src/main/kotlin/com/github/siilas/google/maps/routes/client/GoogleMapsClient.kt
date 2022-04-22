package com.github.siilas.google.maps.routes.client

import com.github.siilas.google.maps.routes.model.Distance
import com.github.siilas.google.maps.routes.model.Route
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

class GoogleMapsClient(
    private val apiKey: String,
    private val webClient: WebClient
) {

    suspend fun getRoute(origin: String, destination: String): Route {
        return webClient.get()
            .uri("/directions/json?origin=$origin&destination=$destination&key=$apiKey")
            .retrieve()
            .awaitBody()
    }

    suspend fun getDistance(origins: String, destinations: String): Distance {
        return webClient.get()
            .uri("/distancematrix/json?origins=$origins&destinations=$destinations&key=$apiKey")
            .retrieve()
            .awaitBody()
    }
}
