package com.karla.appweather

import com.karla.weatherapp.model.WeatherResponse

class WeatherRepository(private val apiService: ApiService) {

    suspend fun getWeather(cityName: String): WeatherResponse {
        return apiService.getCurrentWeather("00e2c84bd20f203250242801", cityName, "no")
    }
}
