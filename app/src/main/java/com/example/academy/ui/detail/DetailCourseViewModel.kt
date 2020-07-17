package com.example.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.utils.DataDummy

class DetailCourseViewModel(private val repo:AcademyRepository): ViewModel() {
    private lateinit var courseId:String

    fun setSelectedCourse(courseId:String){
        this.courseId = courseId
    }

    fun getCourse() : LiveData<CourseEntity> = repo.courseWithModules(courseId)

    fun getModules() : LiveData<List<ModuleEntity>> = repo.allModulesByCourse(courseId)
}