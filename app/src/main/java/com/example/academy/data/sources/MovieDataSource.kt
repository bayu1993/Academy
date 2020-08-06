package com.example.academy.data.sources

import androidx.lifecycle.LiveData
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity

interface MovieDataSource {
    fun getAllMovieList(): LiveData<List<MovieEntity>>
    fun getAllTvShow(): LiveData<List<TvShowEntity>>
    fun getMovie(id:Int): LiveData<MovieEntity>
    fun getTv(id:Int): LiveData<TvShowEntity>
}