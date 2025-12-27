package com.training.weaterapp.databases.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.training.weaterapp.databases.model.FavoriteCity

@Dao
interface FavoriteCityDao {
	@Query("SELECT * FROM favorite_cities")
	suspend fun getAll(): List<FavoriteCity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(city: FavoriteCity)

	@Delete
	suspend fun delete(city: FavoriteCity)
}