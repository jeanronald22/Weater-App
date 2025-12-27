package com.training.weaterapp.data.response

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
	@SerializedName("latitude") val latitude: Double,
	@SerializedName("longitude") val longitude: Double,
	@SerializedName("generationtime_ms") val generationTimeMs: Double,
	@SerializedName("utc_offset_seconds") val utcOffsetSeconds: Int,
	@SerializedName("timezone") val timezone: String,
	@SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
	@SerializedName("elevation") val elevation: Double,
	@SerializedName("current_weather") val currentWeather: CurrentWeather?,
	@SerializedName("hourly") val hourly: Hourly?,
	@SerializedName("daily") val daily: Daily?
)





