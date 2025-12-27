package com.training.weaterapp.databases.repository

import com.training.weaterapp.databases.dao.FavoriteCityDao
import com.training.weaterapp.databases.model.FavoriteCity

class FavoriteCityRepository(
	private val dao: FavoriteCityDao
) {

	suspend fun getCities() = dao.getAll()

	suspend fun addCity(city: FavoriteCity) = dao.insert(city)

	suspend fun removeCity(city: FavoriteCity) = dao.delete(city)
}
