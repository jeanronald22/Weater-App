package com.training.weaterapp.di.modules

import com.training.weaterapp.data.repositoryImpl.GeoCodingAPIImpl
import com.training.weaterapp.data.repositoryImpl.WeatherRepositoryImpl
import com.training.weaterapp.databases.dao.FavoriteCityDao
import com.training.weaterapp.databases.repository.FavoriteCityRepository
import com.training.weaterapp.domain.services.GeoCodingAPI
import com.training.weaterapp.domain.repository.GeoCodingApiRepository
import com.training.weaterapp.domain.repository.WeatherRepository
import com.training.weaterapp.domain.services.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
	@Provides
	@Singleton
	fun provideWeatherRepository(weatherService: WeatherService): WeatherRepository =
		WeatherRepositoryImpl(weatherService)

	@Provides
	@Singleton
	fun provideFavoriteCityRepository(dao: FavoriteCityDao): FavoriteCityRepository =
		FavoriteCityRepository(dao)

	@Provides
	@Singleton
	fun provideCity(api: GeoCodingAPI): GeoCodingApiRepository = GeoCodingAPIImpl(api)
}
