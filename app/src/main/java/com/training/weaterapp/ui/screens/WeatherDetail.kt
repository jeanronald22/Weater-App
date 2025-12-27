package com.training.weaterapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.training.weaterapp.components.EmptyList
import com.training.weaterapp.components.Loader
import com.training.weaterapp.components.weather.WeatherHeader
import com.training.weaterapp.ui.viewModel.HomViewModel
import com.training.weaterapp.ui.viewModel.WeatherDetailViewModel

@Composable
fun WeatherDetail(
	latitude: Double,
	longitude: Double,
	cityName: String,
	navController: NavController,
	viewModel: WeatherDetailViewModel = hiltViewModel()
) {
	LaunchedEffect(latitude, longitude) {
		viewModel.getData(latitude, longitude)
	}
	val weatherData = viewModel.weatherData.collectAsState().value
	when{
		weatherData.isLoading -> {
			Loader()
		}
		weatherData.data == null -> {
			EmptyList(
				"Donnees indisponible",
				"veilleez reesaye plus tard"
			)
		}
		else -> {
			LazyColumn(modifier = Modifier.fillMaxWidth()) {
				item {
					weatherData.data?.let { forecast ->
						WeatherHeader(
							cityName = cityName,
							forecast = forecast
						)
					}
				}
			}
		}
	}
}

