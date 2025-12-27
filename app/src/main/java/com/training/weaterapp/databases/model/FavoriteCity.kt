package com.training.weaterapp.databases.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_cities")
class FavoriteCity(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	val name: String,
	val latitude: Double,
	val longitude: Double
)