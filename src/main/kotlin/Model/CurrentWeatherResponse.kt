package Model

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponse(
    val current: Current,
    val location: Location
)