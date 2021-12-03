package Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    val co: Double,
    @SerialName("gb-defra-index")
    val gb_defra_index: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm2_5: Double,
    val so2: Double,
    @SerialName("us-epa-index")
    val us_epa_index: Int
)