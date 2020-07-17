package com.example.academy.data.sources

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.utils.DataDummy
import com.example.academy.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepo = FakeAcademyRepository(remote)

    private val courseResponse = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponse[0].id
    private val moduleResponse = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponse[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourse() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback).onAllCourseReceived(
                courseResponse
            )
            null
        }.`when`(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        val courseEntity = LiveDataTestUtil.getValue(academyRepo.getAllCourses())
        verify(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        assertNotNull(courseEntity)
        assertEquals(courseResponse.size.toLong(), courseEntity.size.toLong())
    }

    @Test
    fun getAllModuleByCourse() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadModulesCallback).onAllModulesReceived(
                moduleResponse
            )
            null
        }.`when`(remote)
            .getModules(com.nhaarman.mockitokotlin2.eq(courseId), com.nhaarman.mockitokotlin2.any())
        val moduleEntity = LiveDataTestUtil.getValue(academyRepo.allModulesByCourse(courseId))
        verify(remote).getModules(
            com.nhaarman.mockitokotlin2.eq(courseId),
            com.nhaarman.mockitokotlin2.any()
        )
        assertNotNull(moduleEntity)
        assertEquals(moduleResponse.size.toLong(), moduleEntity.size.toLong())
    }

    @Test
    fun getBookmarkCourse() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback).onAllCourseReceived(
                courseResponse
            )
            null
        }.`when`(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        val courseEntity = LiveDataTestUtil.getValue(academyRepo.getBookmarkedCourses())
        verify(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        assertNotNull(courseEntity)
        assertEquals(courseResponse.size.toLong(), courseEntity.size.toLong())
    }

    @Test
    fun getContent() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadModulesCallback).onAllModulesReceived(
                moduleResponse
            )
            null
        }.`when`(remote)
            .getModules(com.nhaarman.mockitokotlin2.eq(courseId), com.nhaarman.mockitokotlin2.any())
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadContentCallback).onContentReceived(
                content
            )
            null
        }.`when`(remote)
            .getContent(com.nhaarman.mockitokotlin2.eq(moduleId), com.nhaarman.mockitokotlin2.any())
        val resultModule = LiveDataTestUtil.getValue(academyRepo.getContent(courseId, moduleId))
        verify(remote).getModules(
            com.nhaarman.mockitokotlin2.eq(courseId),
            com.nhaarman.mockitokotlin2.any()
        )
        verify(remote).getContent(
            com.nhaarman.mockitokotlin2.eq(moduleId),
            com.nhaarman.mockitokotlin2.any()
        )
        assertNotNull(resultModule)
        assertEquals(content.content, resultModule.contentEntity?.content)
    }

    @Test
    fun getCourseWithModule() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback).onAllCourseReceived(
                courseResponse
            )
            null
        }.`when`(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        val resultCourse = LiveDataTestUtil.getValue(academyRepo.courseWithModules(courseId))
        verify(remote).getAllCourse(com.nhaarman.mockitokotlin2.any())
        assertNotNull(resultCourse)
        assertEquals(courseResponse[0].title, resultCourse.title)
    }
}