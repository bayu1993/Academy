package com.example.academy.di

import android.content.Context
import com.example.academy.data.sources.MovieRepository
import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val remoteDataSource =  RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}