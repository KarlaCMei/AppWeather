package com.karla.appweather.data.repository

import com.karla.appweather.data.network.WeatherService
import com.karla.weatherapp.model.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api : WeatherService, private val weatherProvider: WeatherProvider){

    suspend fun getWeatherByCity(query: String): WeatherResponse? {
        val response = api.getWeather(query)
        weatherProvider.quote = response
        return response
    }
}