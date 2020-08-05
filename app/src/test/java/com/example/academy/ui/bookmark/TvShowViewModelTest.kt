package com.example.academy.ui.bookmark

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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        Mockito.`when`(repository.getAllTvShow()).thenReturn(DataDummy.generateDummyTvShow())
        val tvShowEntities = viewModel.getTvShow()
        Mockito.verify(repository).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}