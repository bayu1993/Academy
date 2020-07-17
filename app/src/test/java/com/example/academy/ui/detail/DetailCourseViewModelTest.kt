package com.example.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.AcademyRepository
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
class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId
    private val dummyModule = DataDummy.generateDummyModules(courseId)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var academyRepository: AcademyRepository

    @Mock
    lateinit var observerCourse: Observer<CourseEntity>

    @Mock
    lateinit var observerModule: Observer<List<ModuleEntity>>

    @Before
    fun setUp(){
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }
    @Test
    fun getCourse() {
        val course = MutableLiveData<CourseEntity>()
        course.value = dummyCourse

        Mockito.`when`(academyRepository.courseWithModules(courseId)).thenReturn(course)
        val courseEntity = viewModel.getCourse().value as CourseEntity
        Mockito.verify(academyRepository).courseWithModules(courseId)
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)

        viewModel.getCourse().observeForever(observerCourse)
        verify(observerCourse).onChanged(dummyCourse)
    }

    @Test
    fun getModules() {
        val modules = MutableLiveData<List<ModuleEntity>>()
        modules.value = dummyModule
        Mockito.`when`(academyRepository.allModulesByCourse(courseId)).thenReturn(modules)
        val moduleEntities = viewModel.getModules().value
        Mockito.verify(academyRepository).allModulesByCourse(courseId)
        assertNotNull(moduleEntities)
        assertEquals(7,moduleEntities?.size)

        viewModel.getModules().observeForever(observerModule)
        verify(observerModule).onChanged(dummyModule)
    }
}