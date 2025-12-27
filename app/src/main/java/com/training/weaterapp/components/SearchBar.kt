package com.training.weatherapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun Search(
	query: String,
	onQueryChange: (String) -> Unit,
	modifier: Modifier = Modifier,
	placeholderText: String = "Ville ou aéroport"
) {

	Column(modifier = modifier.fillMaxWidth()) {
			Surface(
				modifier = Modifier.fillMaxSize(),
				color = MaterialTheme.colorScheme.surfaceVariant,
				shape = RoundedCornerShape(16.dp)
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,
					modifier = Modifier
						.fillMaxSize()
						.padding(horizontal = 12.dp, vertical = 10.dp)
				) {
					Icon(
						imageVector = Icons.Default.Search,
						contentDescription = "Search Icon",
						tint = MaterialTheme.colorScheme.onSurfaceVariant
					)
					Spacer(modifier = Modifier.width(8.dp))

					BasicTextField(
						value = query,
						onValueChange = onQueryChange,
						singleLine = true,
						modifier = Modifier.fillMaxWidth().fillMaxHeight(),
						textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
						cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
					) { innerTextField ->
						if (query.isEmpty()) {
							Text(
								text = placeholderText,
								color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
							)
						}
						innerTextField()
					}
				}
			}
		}

}

