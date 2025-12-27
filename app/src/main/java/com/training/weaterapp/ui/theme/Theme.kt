package com.training.weaterapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults.colors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
val DarkColorScheme = darkColorScheme(
	primary = Color(0xFFF9FAFB),
	secondary = Color(0xFF9CA3AF),
	background = Color(0xFF000000),
	surface = Color(0xFF111827),
	outline = Color(0xFF374151),
	onPrimary = Color(0xFF0B0F14),
	onBackground = Color(0xFFF9FAFB),
	onSurface = Color(0xFFF9FAFB)
)


@Composable
fun WeaterAppTheme(
	content: @Composable () -> Unit
) {
	val colorScheme = DarkColorScheme

	val systemUiController = rememberSystemUiController()

	SideEffect {
		systemUiController.setStatusBarColor(
			color = colorScheme.background,
			darkIcons = false
		)
		systemUiController.setNavigationBarColor(
			color = colorScheme.background,
			darkIcons = false
		)
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}
