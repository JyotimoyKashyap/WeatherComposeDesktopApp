package Screens

import Model.Current
import Model.CurrentWeatherResponse
import Utility.loadNetworkImage
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.mouseClickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeatherScreen(currentWeatherResponse: CurrentWeatherResponse?){
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
                .padding(24.dp)
                .clickable {  }
                .shadow(3.dp, RoundedCornerShape(18.dp), clip = true),
            shape = RoundedCornerShape(18.dp),
        ) {

            Column (
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
                    ){
                Image(
                    bitmap = loadNetworkImage("https:"+currentWeatherResponse?.current?.condition?.icon!!),
//                    useResource("drawable/partly_cloudy.png"){
//                        loadImageBitmap(it)
//                    },
                    contentDescription = "Icon for Weather",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(
                            start = 24.dp,
                            end = 12.dp,
                            bottom = 0.dp
                        ),
                    alignment = Alignment.BottomStart
                )
                Row (
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 24.dp
                    )
                ){
                    Text(
                        // TODO : Change the 22°C to " " value
                        text = if(currentWeatherResponse?.current?.feelslike_c == null) "22°C"
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

}

@Composable
@Preview
fun WeatherScreenPreview(){
    WeatherScreen(null)
}

