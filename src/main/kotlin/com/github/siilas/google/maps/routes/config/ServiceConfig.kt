package com.github.siilas.google.maps.routes.config

import com.github.siilas.google.maps.routes.client.GoogleMapsClient
import com.github.siilas.google.maps.routes.service.DistanceService
import com.github.siilas.google.maps.routes.service.RouteService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfig {

    @Bean
    fun distanceService(googleMapsClient: GoogleMapsClient): DistanceService {
        return DistanceService(googleMapsClient)
    }

    @Bean
    fun routeService(googleMapsClient: GoogleMapsClient): RouteService {
        return RouteService(googleMapsClient)
    }
}
