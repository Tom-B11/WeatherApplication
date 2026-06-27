package com.example.weatherapplication.dataclasses

data class DetailedForecast(
    val time: String,
    val tempC: Int,
    val description: String,
    val rainChance: Int,
    val windSpeed: Int
)