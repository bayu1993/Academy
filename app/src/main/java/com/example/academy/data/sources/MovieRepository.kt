package com.example.academy.data.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.data.sources.remote.response.MovieResponse
import com.example.academy.data.sources.remote.response.TvShowResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource)
            }
    }

    override fun getAllMovieList(): LiveData<List<MovieEntity>> {
        val result = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
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
                result.postValue(movieList)
            }

        })
        return result
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val result = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponses: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponses) {
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
                result.postValue(tvShowList)
            }
        })
        return result
    }

    override fun getMovie(id: Int): LiveData<MovieEntity> {
        val result = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var data: MovieEntity
                for (response in movieResponse) {
                    if (response.id == id) {
                        data = MovieEntity(
                            response.id,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.title,
                            response.release_date
                        )
                    }
                }
                result.postValue(data)
            }
        })
        return result
    }

    override fun getTv(id: Int): LiveData<TvShowEntity> {
        val result = MutableLiveData<TvShowEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponses: List<TvShowResponse>) {
                lateinit var data: TvShowEntity
                for (response in tvShowResponses) {
                    if (response.id == id) {
                        data = TvShowEntity(
                            response.id,
                            response.name,
                            response.overview,
                            response.popularity,
                            response.poster_path,
                            response.first_air_date
                        )
                    }
                }
                result.postValue(data)
            }

        })
        return result
    }
}