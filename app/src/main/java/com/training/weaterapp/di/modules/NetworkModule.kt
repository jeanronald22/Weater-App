package com.training.weaterapp.di.modules

import com.training.weaterapp.domain.repository.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
	@Singleton
	fun provideRetrofit(): Retrofit =
		Retrofit.Builder().baseUrl("https://api.open-meteo.com/v1/").build()

	@Provides
	@Singleton
	fun provideWeatherService(retrofit: Retrofit): WeatherService =
		retrofit.create(WeatherService::class.java)
}