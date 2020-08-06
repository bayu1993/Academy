package com.example.academy.data.sources

import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.data.sources.remote.response.MovieResponse
import com.example.academy.data.sources.remote.response.TvShowResponse
import com.example.academy.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest{
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repo = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val tvShowresponse = DataDummy.generateRemoteDummyTvShow()

    @Test
    fun getAllMovie(){
        Mockito.`when`(remote.getAllMovie()).thenReturn(movieResponse as MutableList<MovieResponse>)
        val movieEntities = repo.getAllMovieList()
        Mockito.verify(remote).getAllMovie()

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShow(){
        Mockito.`when`(remote.getAllTvShow()).thenReturn(tvShowresponse as MutableList<TvShowResponse>)
        val tvShowEntities = repo.getAllTvShow()
        Mockito.verify(remote).getAllTvShow()

        assertNotNull(tvShowEntities)
        assertEquals(tvShowresponse.size.toLong(), tvShowEntities.size.toLong())
    }
}