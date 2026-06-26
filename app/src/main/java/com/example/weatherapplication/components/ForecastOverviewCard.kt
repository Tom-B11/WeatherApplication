package com.example.weatherapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R

@Composable
@Preview(showBackground = true)
fun ForecastCard(day: String = "Mon 28th", highTemp: String = "32", lowTemp: String = "19"){

    Card(
        modifier = Modifier
            .height(160.dp)
            .width(120.dp)
            .padding(top = 12.dp)
            .padding(end = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xD9D9D9D9)
        ),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(10.dp)


    ) {    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xD9D9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly


    ) {
        Text(
            text = day,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(start = 4.dp)

        )

        Image(
            painter = painterResource(R.drawable.sunny),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(40.dp)
        )
        Text(
            text = "$highTemp°",
            modifier = Modifier
        )
        Text(
            text = "$lowTemp°",
            modifier = Modifier
        )
    } }

}
