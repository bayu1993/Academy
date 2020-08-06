package com.example.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.MovieRepository
import com.example.academy.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
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

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Test
    fun getMovie() {
        val movies = MutableLiveData<MovieEntity>()
        movies.value = dummyMovie

        viewModel.setSelectedMovie(dummyMovie.id)
        Mockito.`when`(repository.getMovie(movieId)).thenReturn(movies)
        val movieEntity = viewModel.getMovie()?.value
        Mockito.verify(repository).getMovie(movieId)

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity?.id)
        assertEquals(dummyMovie.title, movieEntity?.title)
        assertEquals(dummyMovie.release_date, movieEntity?.release_date)
        assertEquals(dummyMovie.poster_path, movieEntity?.poster_path)
        assertEquals(dummyMovie.overview, movieEntity?.overview)
        movieEntity?.popularity?.let { assertEquals(dummyMovie.popularity, it, 0.0) }

        viewModel.getMovie()?.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        viewModel.setSelectedTvShow(dummyTvShow.id)
        Mockito.`when`(repository.getTv(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow()?.value
        Mockito.verify(repository).getTv(tvShowId)

        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity?.id)
        assertEquals(dummyTvShow.name, tvShowEntity?.name)
        assertEquals(dummyTvShow.first_air_date, tvShowEntity?.first_air_date)
        assertEquals(dummyTvShow.poster_path, tvShowEntity?.poster_path)
        assertEquals(dummyTvShow.overview, tvShowEntity?.overview)
        tvShowEntity?.popularity?.let { assertEquals(dummyTvShow.popularity, it, 0.0) }

        viewModel.getTvShow()?.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)

    }

}