package com.example.weatherapplication.section

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.Forecast
import com.example.weatherapplication.components.ForecastCard

@Preview(showBackground = true)
@Composable
fun FutureOverview(){

    val forecasts = listOf(
        Forecast("Mon 29th", "32","19"),
        Forecast("Tue 30th", "29", "17"),
        Forecast("Wed 1st", "25","12"),
        Forecast("Mon 29th", "32","19"),
        Forecast("Tue 30th", "29","17"),
        Forecast("Wed 1st", "25","12"),

        )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)


    )
    {
        items(forecasts) { forecast ->

            ForecastCard(
                day = forecast.day,
                highTemp = forecast.highTemp,
                lowTemp = forecast.lowTemp
            )
        }
    }
}
