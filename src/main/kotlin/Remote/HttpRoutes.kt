package Remote

object HttpRoutes {

    private const val BASE_URL = "https://api.weatherapi.com/v1"
    const val API_KEY = "aed75529e120456d98661744212709"

    const val CURRENT = "$BASE_URL/current.json?"
    const val FORECAST = "$BASE_URL"

}