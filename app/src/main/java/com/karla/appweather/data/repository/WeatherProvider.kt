package com.karla.appweather.data.repository

import com.karla.weatherapp.model.WeatherResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherProvider @Inject constructor(){
        var quote: WeatherResponse? = null

}