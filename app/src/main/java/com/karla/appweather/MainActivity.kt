package com.karla.appweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.karla.appweather.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val apiService = Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = WeatherRepository(apiService)
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)*/

        val apiService = Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = WeatherRepository(apiService)
        weatherViewModel = ViewModelProvider(this, WeatherViewModelFactory(repository) ).get(WeatherViewModel::class.java)


        binding.btnGet.setOnClickListener {
            val cityName = binding.cityName.text.toString()
            if (cityName.isNotBlank()) {
                weatherViewModel.getWeather(cityName)
            }
        }

        weatherViewModel.weatherData.observe(this) {
            binding.tvResult.text = it
        }

    }
}