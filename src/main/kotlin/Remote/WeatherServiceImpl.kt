package Remote

import Model.CurrentWeatherResponse
import Model.WeatherResponse
import io.ktor.client.*
import io.ktor.client.request.*

class WeatherServiceImpl(private val client: HttpClient) : WeatherService {

    override suspend fun getWeather(): CurrentWeatherResponse {
        return client.get {
            url(HttpRoutes.CURRENT)
            parameter("key", HttpRoutes.API_KEY)
            parameter("q" , "Mangaldai")
            parameter("aqi", "yes")
        }
    }

}