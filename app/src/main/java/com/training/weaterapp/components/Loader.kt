package com.training.weaterapp.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun Loader(){
	CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
}