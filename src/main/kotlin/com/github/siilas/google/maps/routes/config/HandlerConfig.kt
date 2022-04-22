package com.github.siilas.google.maps.routes.config

import com.github.siilas.google.maps.routes.handler.DistanceHandler
import com.github.siilas.google.maps.routes.handler.RouteHandler
import com.github.siilas.google.maps.routes.service.DistanceService
import com.github.siilas.google.maps.routes.service.RouteService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HandlerConfig {

    @Bean
    fun routeHandler(routeService: RouteService): RouteHandler {
        return RouteHandler(routeService)
    }

    @Bean
    fun distanceHandler(distanceService: DistanceService): DistanceHandler {
        return DistanceHandler(distanceService)
    }
}
