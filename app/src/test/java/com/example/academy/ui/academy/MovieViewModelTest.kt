package com.example.academy.ui.academy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.MovieEntity
import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.generateDummyMovieList()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.`when`(repository.getAllMovieList()).thenReturn(movies)
        val movieEntity = viewModel.getMovies().value
        Mockito.verify(repository).getAllMovieList()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}