package com.example.academy.ui.reader

import androidx.lifecycle.ViewModel
import com.example.academy.data.ContentEntity
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.utils.DataDummy

class CourseReaderViewModel(private val repo: AcademyRepository) : ViewModel(){
    private lateinit var courseId:String
    private lateinit var moduleId:String

    fun setSelectedCourse(courseId:String){
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId:String){
        this.moduleId = moduleId
    }

    fun getModules() = repo.allModulesByCourse(courseId)

    fun getSelectedModule() = repo.getContent(courseId, moduleId)
}