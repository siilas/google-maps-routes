package com.github.siilas.google.maps.routes.model

import java.math.BigDecimal
import java.util.Currency

data class Fare(
    val currency: Currency,
    val value: BigDecimal
)
