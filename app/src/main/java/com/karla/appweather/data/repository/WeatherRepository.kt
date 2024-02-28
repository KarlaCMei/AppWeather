package com.karla.appweather.data.repository

import com.karla.appweather.data.network.WeatherService
import com.karla.weatherapp.model.WeatherResponse
import retrofit2.Response

class WeatherRepository {
    private val api = WeatherService()

    suspend fun getWeatherByCity(query: String): WeatherResponse? {
        val response = api.getWeather(query)
        WeatherProvider.quote = response
        return response
    }
}