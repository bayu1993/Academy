package com.example.academy.data.sources.remote

import android.os.Handler
import com.example.academy.data.sources.remote.response.ContentResponse
import com.example.academy.data.sources.remote.response.CourseResponse
import com.example.academy.data.sources.remote.response.ModuleResponse
import com.example.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler()

    companion object {
        const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllCourse(callback: LoadCourseCallback) {
        handler.postDelayed(
            { callback.onAllCourseReceived(jsonHelper.loadCourses()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getContent(moduleId: String, callback: LoadContentCallback) {
        handler.postDelayed(
            { callback.onContentReceived(jsonHelper.loadContent(moduleId)) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getModules(courseId: String, callback: LoadModulesCallback) {
        handler.postDelayed(
            { callback.onAllModulesReceived(jsonHelper.loadModule(courseId)) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadCourseCallback {

        fun onAllCourseReceived(courses: List<CourseResponse>)

    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(module: List<ModuleResponse>)

    }

    interface LoadContentCallback {
        fun onContentReceived(content: ContentResponse)
    }
}