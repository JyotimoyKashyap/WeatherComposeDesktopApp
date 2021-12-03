// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import Model.CurrentWeatherResponse
import Model.WeatherCard
import Model.WeatherResponse
import Remote.WeatherService
import Screens.WeatherScreen
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


private val client = WeatherService.create()

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Weather App",
        resizable = true
    ) {
        val weatherResponse = produceState<CurrentWeatherResponse?>(
            initialValue = null,
            producer = {
                value = client.getWeather()
            }
        )
        DesktopMaterialTheme {
            println("Value of current weather : " + weatherResponse.value?.current?.condition?.text)
            weatherResponse.value?.let { WeatherScreen(it) }
        }
    }
}
