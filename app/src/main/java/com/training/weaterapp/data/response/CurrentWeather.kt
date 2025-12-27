package com.training.weaterapp.data.response

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
	@SerializedName("temperature") val temperature: Double,
	@SerializedName("windspeed") val windSpeed: Double,
	@SerializedName("winddirection") val windDirection: Double,
	@SerializedName("weathercode") val weatherCode: Int,
	@SerializedName("time") val time: String
)