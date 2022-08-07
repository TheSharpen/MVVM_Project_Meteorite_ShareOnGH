package com.example.mvvm_project_meteorite.di

import com.example.mvvm_project_meteorite.MeteoriteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun provideApi(): MeteoriteApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://data.nasa.gov").build().create(MeteoriteApi::class.java)
    }

}