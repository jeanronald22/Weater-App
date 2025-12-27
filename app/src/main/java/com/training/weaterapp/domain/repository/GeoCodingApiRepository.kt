package com.training.weaterapp.domain.repository

import com.training.weaterapp.data.response.CityResponse
import com.training.weaterapp.data.response.GeoCodingResponse

interface GeoCodingApiRepository {
	suspend fun getCities(city: String, count: Int = 10): List<CityResponse>
}