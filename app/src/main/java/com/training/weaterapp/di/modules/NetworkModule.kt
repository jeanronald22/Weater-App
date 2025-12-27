package com.training.weaterapp.di.modules

import com.training.weaterapp.domain.services.GeoCodingAPI
import com.training.weaterapp.domain.services.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module Dagger Hilt responsable de fournir les dépendances liées au réseau.
 *
 * Ce module configure et expose l'instance de [Retrofit] ainsi que les services API
 * (comme [WeatherService]) nécessaires à l'application. Les dépendances fournies
 * sont des singletons, garantissant une instance unique pour tout le cycle de vie de l'application.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
	@Provides
	@GeocodingRetrofit
	@Singleton
	fun provideRetrofit(): Retrofit =
		Retrofit.Builder().baseUrl("https://geocoding-api.open-meteo.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

	@ForecastRetrofit
	@Provides
	@Singleton
	fun provideForecastRetrofit(): Retrofit =
		Retrofit.Builder()
			.baseUrl("https://api.open-meteo.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

	@Provides
	@Singleton
	fun provideWeatherService(@ForecastRetrofit retrofit: Retrofit): WeatherService =
		retrofit.create(WeatherService::class.java)

	@Provides
	@Singleton
	fun provideGeoCodingApi(@GeocodingRetrofit retrofit: Retrofit): GeoCodingAPI = retrofit.create(GeoCodingAPI::class.java)
}