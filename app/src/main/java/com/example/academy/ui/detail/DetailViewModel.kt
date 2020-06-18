package com.example.academy.ui.detail

import androidx.lifecycle.ViewModel
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.utils.DataDummy

class DetailViewModel : ViewModel() {
    private var movieId: Int? = null
    private var tvShowId: Int? = null

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId:Int){
        this.tvShowId = tvShowId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovieList()
        for (movieEntity in movieEntities) {
            if (movieEntity.id == movieId) {
                movie = movieEntity
            }
        }

        return movie
    }

    fun getTvShow(): TvShowEntity{
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShow()
        for (tvShowEntity in tvShowEntities){
            if (tvShowEntity.id == tvShowId){
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

    //fun getModules() = DataDummy.generateDummyModules(movieId)
}