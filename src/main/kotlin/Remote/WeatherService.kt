package Remote

import Model.CurrentWeatherResponse
import Model.WeatherResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface WeatherService {

    suspend fun getWeather() : CurrentWeatherResponse

    companion object{
        fun create() : WeatherService{
            return WeatherServiceImpl(
                client = HttpClient(CIO){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}