package com.example.academy.data.sources

import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity

interface MovieDataSource {
    fun getAllMovieList(): List<MovieEntity>
    fun getAllTvShow(): List<TvShowEntity>
}