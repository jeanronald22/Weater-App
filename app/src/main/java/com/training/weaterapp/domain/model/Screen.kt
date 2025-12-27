package com.training.weaterapp.domain.model

sealed class Screen(val route: String){
	object Home: Screen("home")
	object WeatherDetail: Screen("weather_detail")
}