package com.example.academy.ui.bookmark

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getBookmarks() {
        val courseEntities = viewModel.getTvShow()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}