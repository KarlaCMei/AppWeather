package com.karla.appweather.data.network

import android.telecom.Call
import com.karla.weatherapp.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(@Query("key") apiKey: String, @Query("q") cityName: String, @Query("aqi") includeAqi: String): Response<WeatherResponse>

}