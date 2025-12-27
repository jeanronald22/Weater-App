package com.training.weaterapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.weaterapp.data.response.CityResponse
import com.training.weaterapp.domain.model.UIState
import com.training.weaterapp.domain.repository.GeoCodingApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomViewModel @Inject constructor(
	private val repository: GeoCodingApiRepository
) : ViewModel() {
	private val _cities = MutableStateFlow<UIState<List<CityResponse>>>(UIState())
	val cities: StateFlow<UIState<List<CityResponse>>> = _cities
	private val _query = MutableStateFlow("")
	val query: StateFlow<String> = _query



	fun searchCity(query: String) {
		_query.value = query
		_cities.update { it.copy(isLoading = false) }
		viewModelScope.launch {
			try {
				val response = repository.getCities(query)
				_cities.update { it.copy(data = response, isLoading = false) }
				Log.d("countries", response.toString())
			} catch (e: Exception) {
				e.printStackTrace()
			}finally {
				_cities.update { it.copy(isLoading = false) }
			}
		}
	}

}