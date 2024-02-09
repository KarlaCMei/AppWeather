package com.karla.appweather

import com.karla.weatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /*URL DE LA API
    http://api.weatherapi.com/v1/current.json?key=00e2c84bd20f203250242801&q=Canada&aqi=no*/

    /*@GET("weather")
    suspend fun getWeather(@Query("appid") apiKey: String, @Query("q") cityName: String): WeatherResponse*/

    @GET("current.json")
    suspend fun getCurrentWeather(@Query("key") apiKey: String, @Query("q") cityName: String, @Query("aqi") includeAqi: String): WeatherResponse

}