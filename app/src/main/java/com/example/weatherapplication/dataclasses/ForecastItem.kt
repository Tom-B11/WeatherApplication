package com.example.weatherapplication.dataclasses

data class ForecastItem(
    val main: Main,
    val weather: List <Weather>,
    val wind: Wind,
    val dt_txt: String,
    val pop: Float
)