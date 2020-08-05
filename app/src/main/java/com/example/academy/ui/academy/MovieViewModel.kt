package com.example.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovies() = movieRepository.getAllMovieList()
}