package com.karla.appweather.data.network

import com.karla.appweather.core.RetrofitHelper
import com.karla.weatherapp.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getWeather(query: String): WeatherResponse?  {
        val apiKey = "00e2c84bd2c04aeba0f203250242801"
        val cityName = query
        val includeAqi = "no"

        return withContext(Dispatchers.IO) {
            val call = retrofit.create(ApiService::class.java).getCurrentWeather(apiKey, cityName, includeAqi)
            call.body()

        }
    }

}