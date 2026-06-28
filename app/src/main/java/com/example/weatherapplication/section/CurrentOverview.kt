package com.example.weatherapplication.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.dataclasses.ForecastResponse
import kotlin.math.roundToInt


@Composable
fun CurrentOverview(forecast: ForecastResponse?) {
    val item = forecast?.list?.firstOrNull()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Location",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Image(
            painter = painterResource(R.drawable.sunny),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .padding(top = 18.dp)
        )
        val tempText = if (item != null) {
            println("CURRENT TEMP ${item.main.temp}")
        (item.main.temp - 273.15).roundToInt().toString()
    } else {
        "Loading"
    }
        Text(
            text = tempText,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
        )


    }
}