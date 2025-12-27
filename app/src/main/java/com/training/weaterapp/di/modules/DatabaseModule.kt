package com.training.weaterapp.di.modules

import android.app.Application
import androidx.room.Insert
import androidx.room.Room
import com.training.weaterapp.databases.AppDatabase
import com.training.weaterapp.databases.dao.FavoriteCityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

	@Provides
	@Singleton
	fun provideDatabase(app: Application): AppDatabase{
		return Room.databaseBuilder(
			app,
			AppDatabase::class.java,
			"weather-db"
		).build()
	}

	@Provides
	@Singleton
	fun provideFavoriteCityDao(db: AppDatabase): FavoriteCityDao = db.favoriteCityDao()
}