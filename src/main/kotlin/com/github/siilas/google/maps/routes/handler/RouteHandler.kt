package com.github.siilas.google.maps.routes.handler

import com.github.siilas.google.maps.routes.service.RouteService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

class RouteHandler(
    private val routerService: RouteService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(RouteHandler::class.java)
    }

    suspend fun getRoute(request: ServerRequest): ServerResponse {
        return try {
            val origin = request.queryParam("origin")
                .orElseThrow { throw IllegalArgumentException("Param 'origin' is required") }

            val destination = request.queryParam("destination")
                .orElseThrow { throw IllegalArgumentException("Param 'destination' is required") }

            ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(routerService.getRoute(origin, destination))
        } catch (e: IllegalArgumentException) {
            ServerResponse
                .badRequest()
                .json()
                .bodyValueAndAwait(mapOf("error" to e.message))
        } catch (e: Exception) {
            logger.error("Error getting route", e)

            ServerResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .json()
                .bodyValueAndAwait(mapOf("error" to "Error getting route"))
        }
    }
}
