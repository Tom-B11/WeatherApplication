package com.example.weatherapplication.section

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.components.ForecastOverviewCard
import com.example.weatherapplication.dataclasses.ForecastResponse



@Composable
fun FutureOverview(
    forecasts: ForecastResponse?,
    selectedDate: String?,
    onDateSelected: (String) -> Unit
) {

    val groupedByDay = forecasts?.list
        ?.groupBy { it.dt_txt.split(" ")[0] }
        ?.toSortedMap()
        ?: return

    val dayList = groupedByDay.toList()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(dayList) { (dateString, forecastList) ->

            val isSelected = dateString == selectedDate

            val temps = forecastList.map {
                it.main.temp - 273.15
            }

            val high = temps.maxOrNull()?.toInt() ?: 0
            val low = temps.minOrNull()?.toInt() ?: 0

            val dayNumber = dateString.substringAfterLast("-").toInt()

            ForecastOverviewCard(
                dateString = dateString,
                highTemp = high,
                lowTemp = low,
                isSelected = isSelected,
                onClick = {onDateSelected(dateString)
                }
            )
        }
    }
}
