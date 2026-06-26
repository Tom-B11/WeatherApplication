package com.example.weatherapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.section.CurrentOverview
import com.example.weatherapplication.section.DayOverview
import com.example.weatherapplication.section.FutureOverview

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
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
        CurrentOverview()
        Spacer(modifier = Modifier.height(32.dp))
        FutureOverview()
        Spacer(modifier = Modifier.height(8.dp))
        DayOverview()
    }
}


