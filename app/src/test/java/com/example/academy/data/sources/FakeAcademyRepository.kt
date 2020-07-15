package com.example.academy.data.sources

import com.example.academy.data.ContentEntity
import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.remote.RemoteDataSource

class FakeAcademyRepository(private val remoteDataSource: RemoteDataSource) : AcademyDataSource {

    override fun getAllCourses(): List<CourseEntity> {
        val courseResponse = remoteDataSource.getAllCourse()
        val courseList = mutableListOf<CourseEntity>()

        for (response in courseResponse) {
            val courseEntity = CourseEntity(
                response.id,
                response.title,
                response.description,
                response.date,
                false,
                response.imagePath
            )

            courseList.add(courseEntity)
        }

        return courseList
    }

    override fun getBookmarkedCourses(): List<CourseEntity> {
        val courseResponse = remoteDataSource.getAllCourse()
        val courseList = mutableListOf<CourseEntity>()

        for (response in courseResponse) {
            val courseEntity = CourseEntity(
                response.id,
                response.title,
                response.description,
                response.date,
                false,
                response.imagePath
            )

            courseList.add(courseEntity)
        }

        return courseList
    }

    override fun courseWithModules(courseId: String): CourseEntity {
        val courseResponse = remoteDataSource.getAllCourse()
        lateinit var course: CourseEntity
        for (response in courseResponse) {
            if (response.id == courseId) {
                course = CourseEntity(
                    response.id,
                    response.title,
                    response.description,
                    response.date,
                    false,
                    response.imagePath
                )
            }
        }
        return course
    }

    override fun allModulesByCourse(courseId: String): List<ModuleEntity> {
        val moduleResponse = remoteDataSource.getModules(courseId)
        val moduleList = mutableListOf<ModuleEntity>()
        for (response in moduleResponse) {
            val module = ModuleEntity(
                response.moduleId,
                response.courseId,
                response.title,
                response.position,
                false
            )
            moduleList.add(module)
        }
        return moduleList
    }

    override fun getContent(courseId: String, moduleId: String): ModuleEntity {
        val moduleResponse = remoteDataSource.getModules(courseId)
        lateinit var module: ModuleEntity
        for (response in moduleResponse) {
            if (response.moduleId == moduleId) {
                module = ModuleEntity(
                    response.moduleId,
                    response.courseId,
                    response.title,
                    response.position,
                    false
                )
                module.contentEntity = ContentEntity(remoteDataSource.getContent(moduleId).content)
                break
            }
        }
        return module
    }
}