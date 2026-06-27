package com.example.weatherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import com.example.weatherapplication.dataclasses.ForecastResponse
import com.example.weatherapplication.screens.HomeScreen
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : ComponentActivity() {
    private var forecastState = mutableStateOf<ForecastResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        fetchWeatherData()
        setContent {
            WeatherApplicationTheme() {

                HomeScreen(forecast = forecastState.value)
            }
        }
    }
    private fun fetchWeatherData(){
        println("API KEY = '${BuildConfig.WEATHER_API_KEY}'")
        val key = BuildConfig.WEATHER_API_KEY
         Thread{
            val url = URL("https://api.openweathermap.org/data/2.5/forecast?lat=65.947171&lon=-18.181440&appid=$key")
            val connection = url.openConnection() as HttpsURLConnection
             println("START REQUEST")
             println(connection.responseCode)
            if (connection.responseCode == 200){
                val inputSystem = connection.getInputStream()

                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, ForecastResponse::class.java)

                runOnUiThread {
                    forecastState.value = request
                }
                inputStreamReader.close()
                inputSystem.close()
                println("PARSED: $request")
            }
            else{
                print("Data Not Retrieved")

            }
        }.start()

    }
}
