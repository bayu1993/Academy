package com.example.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId: Int? = null
    private var tvShowId: Int? = null

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getMovie(): LiveData<MovieEntity>? = movieId?.let { movieRepository.getMovie(it) }

    fun getTvShow(): LiveData<TvShowEntity>? = tvShowId?.let { movieRepository.getTv(it) }

}