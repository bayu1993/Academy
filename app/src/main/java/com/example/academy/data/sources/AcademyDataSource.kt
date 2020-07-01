package com.example.academy.data.sources

import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity

interface AcademyDataSource {
    fun getAllCourses() : List<CourseEntity>
    fun getBookmarkedCourses() : List<CourseEntity>
    fun courseWithModules(courseId:String) : CourseEntity
    fun allModulesByCourse(courseId: String) : List<ModuleEntity>
    fun getContent(courseId: String, moduleId:String) : ModuleEntity
}