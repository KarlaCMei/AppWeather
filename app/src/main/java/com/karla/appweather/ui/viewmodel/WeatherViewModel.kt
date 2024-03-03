package com.karla.appweather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karla.appweather.domain.GetWeatherUseCase
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase : GetWeatherUseCase

): ViewModel() {

    private val weather = MutableLiveData<String>()
    val resultWeather: LiveData<String> get() = weather

    fun getWeatherByCity(query: String) {
        viewModelScope.launch {
            val response = getWeatherUseCase.execute(query)
            weather.value =  response?.current?.condition?.text
        }
    }

}