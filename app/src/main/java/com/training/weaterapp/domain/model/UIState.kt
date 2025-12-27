package com.training.weaterapp.domain.model

data class UIState<T>(
	val isLoading: Boolean = false,
	val data: T? = null,
	val error: String? = null

)