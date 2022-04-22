package com.github.siilas.google.maps.routes.handler

import com.github.siilas.google.maps.routes.service.DistanceService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

class DistanceHandler(
    private val distanceService: DistanceService
) {

    companion object {
        private val logger = LoggerFactory.getLogger(DistanceHandler::class.java)
    }

    suspend fun getDistance(request: ServerRequest): ServerResponse {
        return try {
            val origins = request.queryParam("origins")
                .orElseThrow { throw IllegalArgumentException("Param 'origins' is required") }

            val destinations = request.queryParam("destinations")
                .orElseThrow { throw IllegalArgumentException("Param 'destinations' is required") }

            ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(distanceService.getDistance(origins, destinations))
        } catch (e: IllegalArgumentException) {
            ServerResponse
                .badRequest()
                .json()
                .bodyValueAndAwait(mapOf("error" to e.message))
        } catch (e: Exception) {
            logger.error("Error getting distance", e)

            ServerResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .json()
                .bodyValueAndAwait(mapOf("error" to "Error getting distance"))
        }
    }
}
