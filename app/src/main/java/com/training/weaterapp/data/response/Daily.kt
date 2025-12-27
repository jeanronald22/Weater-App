package com.training.weaterapp.data.response

import com.google.gson.annotations.SerializedName

data class Daily(
	@SerializedName("time") val time: List<String>,
	@SerializedName("temperature_2m_max") val temperatureMax: List<Double>,
	@SerializedName("temperature_2m_min") val temperatureMin: List<Double>,
	@SerializedName("precipitation_sum") val precipitation: List<Double>,
	@SerializedName("weathercode") val weatherCode: List<Int>
)