package com.example.mvvm_project_meteorite

import com.example.mvvm_project_meteorite.data.Meteorite
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MeteoriteApi {

    @GET("/resource/gh4g-9sfh.json")
    fun getMeteoriteList(): Flow<List<Meteorite>>

    @GET("/resource/gh4g-9sfh.json/{id}")
    suspend fun getMeteoriteById(
        @Path("id") searchById: String): Meteorite?
}