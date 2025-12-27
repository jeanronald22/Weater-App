package com.training.weaterapp.components.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.training.weaterapp.data.response.CityResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityCard(
	item: CityResponse,
	modifier: Modifier = Modifier,
	onClick: (() -> Unit)? = null
) {
	Card(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = 12.dp, vertical = 6.dp)
			.clickable { onClick?.invoke() },
		shape = RoundedCornerShape(14.dp),
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.surfaceContainerLow
		),
		elevation = CardDefaults.cardElevation(2.dp)
	) {
		Row(
			modifier = Modifier.padding(16.dp),
			horizontalArrangement = Arrangement.spacedBy(14.dp)
		) {

			// --- Flag avatar ---
			AsyncImage(
				model = "https://flagsapi.com/${item.countryCode ?: ""}/flat/64.png",
				contentDescription = "${item.country} flag",
				modifier = Modifier
					.size(46.dp)
					.clip(CircleShape)
			)

			Column(
				modifier = Modifier.weight(1f)
			) {

				// --- City name ---
				Text(
					text = item.name,
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.SemiBold
				)

				Spacer(modifier = Modifier.height(4.dp))

				// --- Country line ---
				Text(
					text = "${item.country} • ${item.admin1 ?: ""}",
					style = MaterialTheme.typography.bodyMedium,
					color = MaterialTheme.colorScheme.onSurfaceVariant
				)

				Spacer(modifier = Modifier.height(2.dp))

				// --- Coordinates ---
				Text(
					text = "Lat: ${item.latitude}, Lon: ${item.longitude}",
					style = MaterialTheme.typography.bodySmall,
					color = MaterialTheme.colorScheme.outline
				)
			}
		}
	}
}
