package com.karla.appweather.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.karla.appweather.data.network.ApiService
import com.karla.appweather.databinding.ActivityMainBinding
import com.karla.appweather.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherViewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        binding.btnGet.setOnClickListener {
            weatherViewModel.getWeatherByCity(binding.cityName.text.toString())
        }

        weatherViewModel.resultWeather.observe(this) { weatherResponse ->
            binding.tvResult.text = weatherResponse.toString()
        }

    }

}