package com.training.weaterapp.components.weather


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.training.weaterapp.data.response.ForecastResponse

@Composable
fun WeatherHeader(
	cityName: String,
	forecast: ForecastResponse,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {

		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Text(
				text = cityName,
				style = MaterialTheme.typography.headlineMedium,
				fontWeight = FontWeight.Bold
			)
		}

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = "${forecast.currentWeather?.temperature ?: "--"}°C",
			style = MaterialTheme.typography.displaySmall,
			fontWeight = FontWeight.ExtraBold,
			color = MaterialTheme.colorScheme.primary,
			modifier = Modifier.fillMaxWidth(),
			textAlign = TextAlign.Center
		)

		Spacer(modifier = Modifier.height(4.dp))

		Text(
			text = "Vent: ${forecast.currentWeather?.windDirection ?: "--"}°",
			style = MaterialTheme.typography.bodyMedium,
			color = MaterialTheme.colorScheme.onSurfaceVariant,
			modifier = Modifier.fillMaxWidth(),
			textAlign = TextAlign.Center
		)
	}
}
