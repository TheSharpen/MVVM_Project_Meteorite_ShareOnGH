package com.example.mvvm_project_meteorite.data

data class Meteorite(
    val fall: String,
    val geolocation: Geolocation,
    val id: String,
    val mass: String,
    val name: String,
    val nametype: String,
    val recclass: String,
    val reclat: String,
    val reclong: String,
    val year: String
)