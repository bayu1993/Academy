package com.example.academy.data.sources

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.utils.DataDummy
import com.example.academy.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repo = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()

    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val movieEntities = LiveDataTestUtils.getValue(repo.getAllMovieList())
        Mockito.verify(remote).getAllMovie(any())

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        doAnswer {
            invocation -> (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
            .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataTestUtils.getValue(repo.getAllTvShow())
        Mockito.verify(remote).getAllTvShow(any())

        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }
}