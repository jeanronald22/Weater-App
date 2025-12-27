package com.training.weaterapp

import android.app.StatusBarManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.training.weaterapp.domain.model.Screen
import com.training.weaterapp.ui.screens.Home
import com.training.weaterapp.ui.screens.WeatherDetail
import com.training.weaterapp.ui.theme.WeaterAppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge(
			statusBarStyle = SystemBarStyle.dark(scrim = Color.Transparent.hashCode()),
		)
		setContent {
			WeaterAppTheme {
				val navController = rememberNavController()

				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					NavHost(
						navController = navController,
						startDestination = Screen.Home.route,
						modifier = Modifier.padding(innerPadding)
					) {
						composable(Screen.Home.route) {
							Home(navController = navController)
						}

						composable(
							route = "${Screen.WeatherDetail.route}/{lat}/{lon}/{cityName}",
							arguments = listOf(
								navArgument("lat") { type = NavType.FloatType },
								navArgument("lon") { type = NavType.FloatType },
								navArgument("cityName") { type = NavType.StringType }
							)
						) { backStackEntry ->
							val lat = backStackEntry.arguments?.getFloat("lat") ?: 0f
							val lon = backStackEntry.arguments?.getFloat("lon") ?: 0f
							val cityName = backStackEntry.arguments?.getString("cityName") ?: ""
							WeatherDetail(
								latitude = lat.toDouble(),
								longitude = lon.toDouble(),
								cityName = cityName,
								navController
							)
						}
					}
				}
			}
		}
	}
}
