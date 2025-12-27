package com.training.weaterapp.data.response

import com.google.gson.annotations.SerializedName

data class Hourly(
	@SerializedName("time") val time: List<String>,
	@SerializedName("temperature_2m") val temperature: List<Double>,
	@SerializedName("precipitation") val precipitation: List<Double>,
	@SerializedName("weathercode") val weatherCode: List<Int>
)
