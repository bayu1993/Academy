package com.example.academy.data.sources

import androidx.lifecycle.LiveData
import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity

interface AcademyDataSource {
    fun getAllCourses() : LiveData<List<CourseEntity>>
    fun getBookmarkedCourses() : LiveData<List<CourseEntity>>
    fun courseWithModules(courseId:String) : LiveData<CourseEntity>
    fun allModulesByCourse(courseId: String) : LiveData<List<ModuleEntity>>
    fun getContent(courseId: String, moduleId:String) : LiveData<ModuleEntity>
}