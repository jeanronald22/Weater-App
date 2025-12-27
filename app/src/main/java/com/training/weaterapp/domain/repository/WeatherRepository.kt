package com.training.weaterapp.domain.repository

interface WeatherRepository {
	suspend fun getWeather(city: String)
}