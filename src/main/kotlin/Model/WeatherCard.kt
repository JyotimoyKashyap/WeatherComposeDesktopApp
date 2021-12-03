package Model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherCard(
    val condition: String,
    val iconUrl: String,
    val temperature: Double,
    val feelsLike: Double,
    val chanceOfRain: Double? = null
)

