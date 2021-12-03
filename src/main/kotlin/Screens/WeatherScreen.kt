package Screens

import Model.CurrentWeatherResponse
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeatherScreen(currentWeatherResponse: CurrentWeatherResponse){
    var queriedCity by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
                ){

            // text field to add text
            TextField(
                value = queriedCity,
                onValueChange = { queriedCity = it},
                modifier = Modifier.padding(end = 16.dp).weight(1f),
                placeholder = { Text("Any city, really . . .") },
                label = { Text(text = "Search for a city ") },
                leadingIcon = { Icon(Icons.Filled.LocationOn, "Location") }
            )

            // button to search
            Button(
                onClick = {}
            ){
                Icon(Icons.Outlined.Search, "Search")
            }

        }

        Card(
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
                .padding(24.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
                    ){
                Text(
                    text = if(currentWeatherResponse.current.feelslike_c == null) " "
                    else currentWeatherResponse.current.feelslike_c.toInt().toString() + "°C",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }
        }
    }

}

