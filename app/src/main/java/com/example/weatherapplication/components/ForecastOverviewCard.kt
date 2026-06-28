package com.example.weatherapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
fun ForecastOverviewCard(dateString: String, highTemp: Int, lowTemp: Int, isSelected: Boolean, onClick:()-> Unit){
    val dayNumber = dateString.substringAfterLast("-").toInt()
    val label = dayNumber.toOrdinal()
    Card(
        modifier = Modifier
            .height(160.dp)
            .width(120.dp)
            .padding(top = 12.dp)
            .padding(end = 12.dp)
            .clickable{onClick()}
            .offset(y = if (isSelected) (-6).dp else 0.dp),
        colors = CardDefaults.cardColors(
            if (isSelected) Color(0xffB0BEC5) else Color(0xffD9D9D9)

        ),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 10.dp else 2.dp
        )


    ) {    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly


    ) {
        Text(
            text = label,
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
fun Int.toOrdinal(): String{
    return when{
        this in 11..13 -> "${this}th"
        this % 10 == 1 -> "${this}st"
        this % 10 == 2 -> "${this}nd"
        this % 10 == 3 -> "${this}rd"
        else -> "${this}th"
    }
}