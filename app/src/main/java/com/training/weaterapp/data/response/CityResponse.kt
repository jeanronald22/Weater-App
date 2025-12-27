package com.training.weaterapp.data.response

import com.google.gson.annotations.SerializedName

data class CityResponse(
	val id: Long,
	val name: String,
	val latitude: Double,
	val longitude: Double,
	@SerializedName("country_code")
	val countryCode: String,
	val country: String,
	val admin1: String? = null,
	val admin2: String? = null,
	val admin3: String? = null,
	val admin4: String? = null
)
