package com.example.academy.data.sources

import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.remote.RemoteDataSource

class FakeMovieRepository (private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    override fun getAllMovieList(): List<MovieEntity> {
        val movieResponse = remoteDataSource.getAllMovie()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponse) {
            val data = MovieEntity(
                response.id,
                response.overview,
                response.popularity,
                response.poster_path,
                response.title,
                response.release_date
            )
            movieList.add(data)
        }
        return movieList
    }

    override fun getAllTvShow(): List<TvShowEntity> {
        val tvShowResponse = remoteDataSource.getAllTvShow()
        val tvShowList = ArrayList<TvShowEntity>()
        for (response in tvShowResponse) {
            val data = TvShowEntity(
                response.id,
                response.name,
                response.overview,
                response.popularity,
                response.poster_path,
                response.first_air_date
            )
            tvShowList.add(data)
        }
        return tvShowList
    }
}