package com.training.weaterapp.domain.repository

import com.training.weaterapp.data.response.ForecastResponse

interface WeatherRepository {
	suspend fun getForecast(lat: Double, long: Double): ForecastResponse
}