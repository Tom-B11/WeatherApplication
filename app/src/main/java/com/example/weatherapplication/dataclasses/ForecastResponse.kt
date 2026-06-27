package com.example.weatherapplication.dataclasses

data class ForecastResponse (
    val cod: String,
    val list: List<ForecastItem>
)