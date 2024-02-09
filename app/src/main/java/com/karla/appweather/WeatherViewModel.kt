package com.karla.appweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableLiveData<String>()
    val weatherData: LiveData<String>
        get() = _weatherData

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            try {
                val response = repository.getWeather(cityName)
                _weatherData.value = "CLIMA: ${response.current.condition.text}"
            } catch (e: Exception) {
                // Manejar errores
                _weatherData.value = "Error obteniendo el clima"
            }
        }
    }


}
