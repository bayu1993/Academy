package com.example.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy

class TvShowViewModel(private val movieRepository: MovieRepository):ViewModel() {
    fun getTvShow() : LiveData<List<TvShowEntity>> = movieRepository.getAllTvShow()
}