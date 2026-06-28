package com.example.weatherapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.dataclasses.ForecastResponse
import com.example.weatherapplication.section.CurrentOverview
import com.example.weatherapplication.section.DayOverview
import com.example.weatherapplication.section.FutureOverview
@Composable
fun HomeScreen(forecast: ForecastResponse?) {

    var selectedDate by remember { mutableStateOf<String?>(null) }

    if (selectedDate == null) {
        selectedDate = forecast?.list
            ?.firstOrNull()
            ?.dt_txt
            ?.split(" ")
            ?.get(0)
    }


Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2F618D),
                        Color(0xFF8BC6FF)
                    )
                )
            )
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        CurrentOverview(forecast)

        Spacer(modifier = Modifier.height(32.dp))

        FutureOverview(
            forecasts = forecast,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DayOverview(
            forecasts = forecast,
            selectedDate = selectedDate
        )
    }
}