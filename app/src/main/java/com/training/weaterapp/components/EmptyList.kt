package com.training.weaterapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EmptyList(
	title: String,
	subtitle: String? = null,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Text(
			text = title,
			style = MaterialTheme.typography.titleLarge,
			fontWeight = FontWeight.Bold
		)

		if (!subtitle.isNullOrEmpty()) {
			Spacer(modifier = Modifier.height(6.dp))

			Text(
				text = subtitle,
				style = MaterialTheme.typography.bodyMedium,
				color = MaterialTheme.colorScheme.onSurfaceVariant
			)
		}
	}
}
