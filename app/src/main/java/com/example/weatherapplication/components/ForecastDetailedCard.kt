package com.example.weatherapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R


@Composable
fun ForecastDetailedCard (time: String, tempC: Int, description: String, rainChance: Int, windSpeed: Int){

    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(top = 24.dp)
            .padding(bottom = 24.dp)
            .padding(end = 12.dp)
            .fillMaxHeight(),

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
            text = time,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 8.dp)

        )

        Image(
            painter = painterResource(R.drawable.sunny),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(40.dp)
        )
        Text(
            text = "$tempC°",
            modifier = Modifier
        )
        Image(
            painter = painterResource(R.drawable.waterdrop),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = "<$rainChance%",
            modifier = Modifier
                .padding(top = 8.dp)
        )
        Image(
            painter = painterResource(R.drawable.wind),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = "$windSpeed mph",
            modifier = Modifier
                .padding(top = 8.dp)
        )

    } }

}

