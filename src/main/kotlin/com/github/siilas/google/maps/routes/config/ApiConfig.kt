package com.github.siilas.google.maps.routes.config

import com.github.siilas.google.maps.routes.handler.DistanceHandler
import com.github.siilas.google.maps.routes.handler.RouteHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ApiConfig(
    private val routeHandler: RouteHandler,
    private val distanceHandler: DistanceHandler
) {

    @Bean
    fun routes() = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/route", routeHandler::getRoute)
            GET("/distance", distanceHandler::getDistance)
        }
    }
}
