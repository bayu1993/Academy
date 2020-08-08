package com.example.academy.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var repository: MovieRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(repository.getAllTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow().value
        Mockito.verify(repository).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}