package com.example.academy.ui.reader

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.ContentEntity
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
class CourseReaderViewModelTest {

    private lateinit var viewModel: CourseReaderViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId
    private val dummyModules = DataDummy.generateDummyModules(courseId)
    private val moduleId = dummyModules[0].moduleId

    @Mock
    lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp(){
        viewModel = CourseReaderViewModel(academyRepository)
        viewModel.setSelectedModule(moduleId)
        viewModel.setSelectedCourse(courseId)

        val dummyModule = dummyModules[0]
        dummyModule.contentEntity = ContentEntity("<h3 class=\\\"fr-text-bordered\\\">"+dummyModule.title+"</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
    }

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var observerModules: Observer<List<ModuleEntity>>

    @Mock
    lateinit var observerModule: Observer<ModuleEntity>

    @Test
    fun getModules() {
        val modules = MutableLiveData<List<ModuleEntity>>()
        modules.value = dummyModules

        Mockito.`when`(academyRepository.allModulesByCourse(courseId)).thenReturn(modules)
        val moduleEntities = viewModel.getModules().value
        Mockito.verify(academyRepository).allModulesByCourse(courseId)
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities?.size)

        viewModel.getModules().observeForever(observerModules)
        verify(observerModules).onChanged(dummyModules)
    }

    @Test
    fun getSelectedModule() {
        val module = MutableLiveData<ModuleEntity>()
        module.value = dummyModules[0]
        Mockito.`when`(academyRepository.getContent(courseId, moduleId)).thenReturn(module)
        val moduleEntity = viewModel.getSelectedModule().value as ModuleEntity
        Mockito.verify(academyRepository).getContent(courseId, moduleId)
        assertNotNull(moduleEntity)
        val contentEntity = moduleEntity.contentEntity
        assertNotNull(contentEntity)
        val content = contentEntity?.content
        assertNotNull(content)
        assertEquals(content, dummyModules[0].contentEntity?.content)

        viewModel.getSelectedModule().observeForever(observerModule)
        verify(observerModule).onChanged(dummyModules[0])
    }
}