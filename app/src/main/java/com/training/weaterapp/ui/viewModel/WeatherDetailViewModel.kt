package com.training.weaterapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.weaterapp.data.response.ForecastResponse
import com.training.weaterapp.di.modules.ForecastRetrofit
import com.training.weaterapp.domain.model.UIState
import com.training.weaterapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
	private val repository: WeatherRepository
): ViewModel(){
	private val _weatherData = MutableStateFlow<UIState<ForecastResponse>>(UIState())
	val weatherData: StateFlow<UIState<ForecastResponse>> = _weatherData

	fun getData(latitude: Double, longitude: Double){
		viewModelScope.launch {
			_weatherData.update { it.copy(isLoading = true) }
			try {
				val response = repository.getForecast(latitude, longitude)
				_weatherData.update { it.copy(data = response, isLoading = false) }
				Log.d("cty data", _weatherData.value.toString())
			}catch (e: Exception){
				e.printStackTrace()
			}finally {
				_weatherData.update { it.copy(isLoading = false) }
			}

		}
	}

}