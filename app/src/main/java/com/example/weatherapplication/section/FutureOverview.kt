package com.example.weatherapplication.section

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.dataclasses.Forecast
import com.example.weatherapplication.components.ForecastOverviewCard
import com.example.weatherapplication.dataclasses.ForecastResponse

@Composable
fun FutureOverview(forecasts: ForecastResponse?) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)


    )
    {
        val groupedByDay = forecasts?.list?.groupBy { it.dt_txt.split(" ")[0] }


        groupedByDay?.forEach { (date, forecastList) ->
            val tempC = forecastList.map{
                it.main.temp - 273.15
            }
            val high = tempC.maxOrNull()?.toInt() ?: 0
            val low = tempC.minOrNull()?.toInt() ?: 0
            val date = date.split("-")[2].toInt()
            item{
            ForecastOverviewCard(
                day =date.toOrdinal(),
                highTemp = high,
                lowTemp = low


            )
                }
        }
    }
        }

fun Int.toOrdinal(): String{
    return when{
        this in 11..13 -> "${this}th"
        this % 10 == 1 -> "${this}st"
        this % 10 == 2 -> "${this}nd"
        this % 10 == 3 -> "${this}rd"
        else -> "${this}th"
    }
}


