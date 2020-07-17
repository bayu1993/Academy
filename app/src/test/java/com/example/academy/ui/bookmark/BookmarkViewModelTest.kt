package com.example.academy.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.CourseEntity
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
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var academyRepository: AcademyRepository

    @Mock
    lateinit var observer: Observer<List<CourseEntity>>

    @Before
    fun setUp(){
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmarks() {
        val dataDummy = DataDummy.generateDummyCourses()
        val course = MutableLiveData<List<CourseEntity>>()
        course.value = dataDummy

        Mockito.`when`(academyRepository.getBookmarkedCourses()).thenReturn(course)
        val courseEntities = viewModel.getBookmarks().value
        Mockito.verify(academyRepository).getBookmarkedCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getBookmarks().observeForever(observer)
        verify(observer).onChanged(dataDummy)
    }
}