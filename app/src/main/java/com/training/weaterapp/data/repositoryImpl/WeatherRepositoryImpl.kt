package com.training.weaterapp.data.repositoryImpl

import com.training.weaterapp.data.response.ForecastResponse
import com.training.weaterapp.domain.repository.WeatherRepository
import com.training.weaterapp.domain.services.WeatherService
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
	private val weatherService: WeatherService
): WeatherRepository {
	override suspend fun getForecast(lat: Double, long: Double): ForecastResponse {
		return weatherService.getForecast(lat, long)
	}
}