package com.github.siilas.google.maps.routes.config

import com.github.siilas.google.maps.routes.client.GoogleMapsClient
import com.github.siilas.google.maps.routes.exception.ConfigurationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ClientConfig {

    @Bean
    fun googleMapsClient(
        builder: WebClient.Builder,
        @Value("\${google.maps.key}") apiKey: String,
        @Value("\${google.maps.host}") apiHost: String
    ): GoogleMapsClient {
        if (apiKey.isBlank()) {
            throw ConfigurationException("Config 'google.maps.key' is required")
        }
        if (apiHost.isBlank()) {
            throw ConfigurationException("Config 'google.maps.host' is required")
        }
        return GoogleMapsClient(apiKey, builder.baseUrl(apiHost).build())
    }
}
