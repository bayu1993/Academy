package com.example.academy.ui.reader

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.AcademyRepository

class CourseReaderViewModel(private val repo: AcademyRepository) : ViewModel(){
    private lateinit var courseId:String
    private lateinit var moduleId:String

    fun setSelectedCourse(courseId:String){
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId:String){
        this.moduleId = moduleId
    }

    fun getModules() : LiveData<List<ModuleEntity>> = repo.allModulesByCourse(courseId)

    fun getSelectedModule() : LiveData<ModuleEntity> = repo.getContent(courseId, moduleId)
}