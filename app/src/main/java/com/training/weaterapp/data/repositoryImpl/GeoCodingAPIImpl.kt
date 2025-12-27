package com.training.weaterapp.data.repositoryImpl

import com.training.weaterapp.data.response.CityResponse
import com.training.weaterapp.domain.services.GeoCodingAPI
import com.training.weaterapp.domain.repository.GeoCodingApiRepository
import javax.inject.Inject

class GeoCodingAPIImpl @Inject constructor(
	private val geoCodingApi: GeoCodingAPI
) : GeoCodingApiRepository {
	override suspend fun getCities(city: String, count: Int): List<CityResponse> {
		return geoCodingApi.searchCity(city, count).results?:emptyList()
	}
}