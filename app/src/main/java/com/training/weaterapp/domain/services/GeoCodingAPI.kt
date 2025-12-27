package com.training.weaterapp.domain.services

import com.training.weaterapp.data.response.GeoCodingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodingAPI {
	/**
	 * Recherche des villes par nom
	 * @param name : le nom de la ville
	 * @param count : nombre maximum de résultats
	 */
	@GET("v1/search")
	suspend fun searchCity(
		@Query("name") name: String,
		@Query("count") count: Int = 10
	): GeoCodingResponse
}