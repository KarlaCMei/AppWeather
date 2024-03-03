package com.karla.appweather.data.network

import com.karla.appweather.core.RetrofitHelper
import com.karla.weatherapp.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherService @Inject constructor(private val api : ApiService){
    suspend fun getWeather(query: String): WeatherResponse?  {
        val apiKey = "00e2c84bd2c04aeba0f203250242801"
        val cityName = query
        val includeAqi = "no"

        return withContext(Dispatchers.IO) {
            val call = api.getCurrentWeather(apiKey, cityName, includeAqi)
            call.body()

        }
    }

}