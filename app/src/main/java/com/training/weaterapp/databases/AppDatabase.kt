package com.training.weaterapp.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.weaterapp.databases.dao.FavoriteCityDao
import com.training.weaterapp.databases.model.FavoriteCity

@Database(
	entities = [FavoriteCity::class],
	version = 1
)
abstract class AppDatabase: RoomDatabase() {
	abstract fun favoriteCityDao(): FavoriteCityDao

}