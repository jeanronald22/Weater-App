package com.training.weaterapp.data.repositoryImpl

import com.training.weaterapp.domain.repository.WeatherRepository
import com.training.weaterapp.domain.repository.WeatherService
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
	private val weatherService: WeatherService
): WeatherRepository {
	override suspend fun getWeather(city: String) {
	}
}