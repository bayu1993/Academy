package com.example.academy.data.sources

import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.data.sources.remote.response.CourseResponse
import com.example.academy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyRepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepo = FakeAcademyRepository(remote)

    private val courseResponse = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponse[0].id
    private val moduleResponse = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponse[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourse() {
        `when`(remote.getAllCourse()).thenReturn(courseResponse)
        val courseEntity = academyRepo.getAllCourses()
        verify(remote).getAllCourse()
        assertNotNull(courseEntity)
        assertEquals(courseResponse.size.toLong(), courseEntity.size.toLong())
    }

    @Test
    fun getAllModuleByCourse() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponse)
        val moduleEntity = academyRepo.allModulesByCourse(courseId)
        verify(remote).getModules(courseId)
        assertNotNull(moduleEntity)
        assertEquals(moduleResponse.size.toLong(), moduleEntity.size.toLong())
    }

    @Test
    fun getBookmarkCourse() {
        `when`(remote.getAllCourse()).thenReturn(courseResponse)
        val courseEntity = academyRepo.getBookmarkedCourses()
        verify(remote).getAllCourse()
        assertNotNull(courseEntity)
        assertEquals(courseResponse.size.toLong(), courseEntity.size.toLong())
    }

    @Test
    fun getContent() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponse)
        `when`(remote.getContent(moduleId)).thenReturn(content)
        val resultModule = academyRepo.getContent(courseId, moduleId)
        verify(remote).getContent(moduleId)
        assertNotNull(resultModule)
        assertEquals(content.content, resultModule.contentEntity?.content)
    }

    @Test
    fun getCourseWithModule() {
        `when`(remote.getAllCourse()).thenReturn(courseResponse)
        val resultCourse = academyRepo.courseWithModules(courseId)
        verify(remote).getAllCourse()
        assertNotNull(resultCourse)
        assertEquals(courseResponse[0].title, resultCourse.title)
    }
}