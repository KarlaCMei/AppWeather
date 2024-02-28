package com.karla.appweather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karla.appweather.domain.GetWeatherUseCase
import com.karla.weatherapp.model.WeatherResponse
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    private val getWeatherUseCase = GetWeatherUseCase()

    private val weather = MutableLiveData<String>()
    val resultWeather: LiveData<String> get() = weather

    fun getWeatherByCity(query: String) {
        viewModelScope.launch {
            val response = getWeatherUseCase.execute(query)
            weather.value =  response?.current?.condition?.text
        }
    }

}