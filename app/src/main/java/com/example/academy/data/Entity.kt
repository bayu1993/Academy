package com.example.academy.data

data class MovieEntity(
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val title: String,
    val release_date: String
)

data class TvShowEntity(
    val id: Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val first_air_date: String
)