package com.example.academy.data.sources.remote

import com.example.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllCourse() = jsonHelper.loadCourses()
    fun getModules(courseId: String) = jsonHelper.loadModule(courseId)
    fun getContent(moduleId: String) = jsonHelper.loadContent(moduleId)
}