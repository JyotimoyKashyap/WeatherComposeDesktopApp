package Model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val currentWeather: WeatherCard,
    val forecast: List<WeatherCard>
)
