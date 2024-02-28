package com.karla.appweather.domain

import com.karla.appweather.data.repository.WeatherRepository
import com.karla.weatherapp.model.WeatherResponse
import retrofit2.Response

class GetWeatherUseCase {
    private val repository = WeatherRepository()

    suspend fun execute(query: String): WeatherResponse? {
        return repository.getWeatherByCity(query)
    }
}