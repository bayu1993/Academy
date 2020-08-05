package com.example.academy.ui.detail

import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovieList()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp(){
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }
    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.id)
        Mockito.`when`(repository.getAllMovieList()).thenReturn(DataDummy.generateDummyMovieList())
        val movieEntity = viewModel.getMovie()
        Mockito.verify(repository).getAllMovieList()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.release_date, movieEntity.release_date)
        assertEquals(dummyMovie.poster_path, movieEntity.poster_path)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.popularity, movieEntity.popularity,0.0)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.id)
        Mockito.`when`(repository.getAllTvShow()).thenReturn(DataDummy.generateDummyTvShow())
        val tvShowEntity = viewModel.getTvShow()
        Mockito.verify(repository).getAllTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.name, tvShowEntity.name)
        assertEquals(dummyTvShow.first_air_date, tvShowEntity.first_air_date)
        assertEquals(dummyTvShow.poster_path, tvShowEntity.poster_path)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.popularity, tvShowEntity.popularity,0.0)
    }

}