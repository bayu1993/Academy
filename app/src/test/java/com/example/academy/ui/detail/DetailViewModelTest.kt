package com.example.academy.ui.detail

import com.example.academy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(courseId)
    }
    @Test
    fun getCourse() {
        viewModel.setSelectedMovie(dummyCourse.courseId)
        val courseEntity = viewModel.getMovie()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
    }

    @Test
    fun getModules() {
        val moduleEntities = viewModel.getModules()
        assertNotNull(moduleEntities)
        assertEquals(7,moduleEntities.size)
    }
}