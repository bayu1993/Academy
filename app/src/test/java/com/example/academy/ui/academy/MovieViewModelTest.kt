package com.example.academy.ui.academy

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getCourses() {
        val courseEntity = viewModel.getCourses()
        assertNotNull(courseEntity)
        assertEquals(5, courseEntity.size)
    }
}