package com.training.weaterapp.domain.services

import com.training.weaterapp.data.response.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
	@GET("v1/forecast")
	suspend fun getForecast(
		@Query("latitude") latitude: Double,
		@Query("longitude") longitude: Double,
		@Query("hourly") hourly: String = "temperature_2m,precipitation,weathercode",
		@Query("daily") daily: String = "temperature_2m_max,temperature_2m_min,precipitation_sum,weathercode",
		@Query("current_weather") currentWeather: Boolean = true,
		@Query("timezone") timezone: String = "auto"
	): ForecastResponse
}