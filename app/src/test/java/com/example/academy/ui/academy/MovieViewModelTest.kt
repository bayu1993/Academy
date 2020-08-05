package com.example.academy.ui.academy

import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp(){
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        Mockito.`when`(repository.getAllMovieList()).thenReturn(DataDummy.generateDummyMovieList())
        val movieEntity = viewModel.getMovies()
        Mockito.verify(repository).getAllMovieList()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity.size)
    }
}