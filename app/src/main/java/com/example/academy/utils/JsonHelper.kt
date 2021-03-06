package com.example.academy.utils

import android.content.Context
import android.util.Log
import com.example.academy.data.sources.remote.response.ContentResponse
import com.example.academy.data.sources.remote.response.CourseResponse
import com.example.academy.data.sources.remote.response.ModuleResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(filename: String): String? {
        return try {
            val `is` = context.assets.open(filename)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadCourses(): List<CourseResponse> {
        val list = mutableListOf<CourseResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
            val listArray = responseObject.getJSONArray("courses")
            for (i in 0..listArray.length()) {
                val course = listArray.getJSONObject(i)
                val id = course.getString("id")
                val title = course.getString("title")
                val desc = course.getString("description")
                val date = course.getString("date")
                val imagePath = course.getString("imagePath")

                val courseResponse = CourseResponse(id, title, desc, date, imagePath)
                list.add(courseResponse)
            }
            Log.d("cek data jsonhelper", "data >>> ${list.size}")
        } catch (e: JSONException) {
            e.printStackTrace()
            Log.e("cek data jsonhelper", "error >>> ${e.localizedMessage}")
        }
        return list
    }

    fun loadModule(courseId: String): List<ModuleResponse> {
        val fileName = String.format("Module_%s.json", courseId)
        val list = mutableListOf<ModuleResponse>()

        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("modules")
                for (i in 0..listArray.length()) {
                    val course = listArray.getJSONObject(i)

                    val moduleId = course.getString("moduleId")
                    val position = course.getString("position")
                    val title = course.getString("title")

                    val courseResponse =
                        ModuleResponse(moduleId, courseId, title, Integer.parseInt(position))
                    list.add(courseResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadContent(moduleId:String) : ContentResponse{
        val fileName = String.format("Content_%s", moduleId)
        var contentResponse: ContentResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null){
                val responseObject = JSONObject(result)
                val content = responseObject.getString("content")
                contentResponse = ContentResponse(moduleId, content)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return contentResponse as ContentResponse
    }
}