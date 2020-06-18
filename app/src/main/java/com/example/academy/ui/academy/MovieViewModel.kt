package com.example.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.example.academy.utils.DataDummy

class MovieViewModel: ViewModel() {

    fun getMovies() = DataDummy.generateDummyMovieList()
}