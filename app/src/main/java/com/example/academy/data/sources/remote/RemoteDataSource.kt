package com.example.academy.data.sources.remote

import android.os.Handler
import com.example.academy.data.sources.remote.response.MovieResponse
import com.example.academy.data.sources.remote.response.TvShowResponse
import com.example.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler()

    companion object {
        const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovie(callback: LoadMoviesCallback) {
        handler.postDelayed(
            { callback.onAllMovieReceived(jsonHelper.loadMovieList()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTvShow(callback: LoadTvShowCallback) {
        handler.postDelayed(
            { callback.onAllTvShowReceived(jsonHelper.loadTvList()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponses: List<TvShowResponse>)
    }
}