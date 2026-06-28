package com.example.weatherapplication.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.components.ForecastDetailedCard
import com.example.weatherapplication.dataclasses.DetailedForecast
import com.example.weatherapplication.dataclasses.ForecastResponse


@Composable
fun DayOverview(
    forecasts: ForecastResponse?,
    selectedDate: String?
) {
    if (selectedDate == null) return

    val filtered = forecasts?.list?.filter {
        it.dt_txt.split(" ")[0] == selectedDate
    } ?: return

    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 32.dp)
            .fillMaxSize(),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xD9D9D9D9)
        ),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {

                itemsIndexed(filtered) { _, forecast ->

                    val (_, time) = forecast.dt_txt.split(" ")
                    val formattedTime = time.substring(0, 5)

                    ForecastDetailedCard(
                        time = formattedTime,
                        tempC = (forecast.main.temp - 273.15).toInt(),
                        description = forecast.weather[0].main,
                        rainChance = (forecast.pop * 100).toInt(),
                        windSpeed = forecast.wind.speed.toInt()
                    )
                }
            }
        }
    }
}