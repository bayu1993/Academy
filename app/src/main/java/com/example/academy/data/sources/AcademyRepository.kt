package com.example.academy.data.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.academy.data.ContentEntity
import com.example.academy.data.CourseEntity
import com.example.academy.data.ModuleEntity
import com.example.academy.data.sources.remote.RemoteDataSource
import com.example.academy.data.sources.remote.response.ContentResponse
import com.example.academy.data.sources.remote.response.CourseResponse
import com.example.academy.data.sources.remote.response.ModuleResponse

class AcademyRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    AcademyDataSource {
    companion object {
        @Volatile
        private var instance: AcademyRepository? = null

        fun getInstancce(remoteData: RemoteDataSource): AcademyRepository =
            instance ?: synchronized(this) {
                instance ?: AcademyRepository(remoteData)
            }
    }

    override fun getAllCourses(): LiveData<List<CourseEntity>> {
        val courseResult = MutableLiveData<List<CourseEntity>>()
        remoteDataSource.getAllCourse(object : RemoteDataSource.LoadCourseCallback {
            override fun onAllCourseReceived(courses: List<CourseResponse>) {
                val courseList = mutableListOf<CourseEntity>()

                for (response in courses) {
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
                courseResult.postValue(courseList)
            }

        })

        return courseResult
    }

    override fun getBookmarkedCourses(): LiveData<List<CourseEntity>> {
        val courseResult = MutableLiveData<List<CourseEntity>>()
        remoteDataSource.getAllCourse(object : RemoteDataSource.LoadCourseCallback {
            override fun onAllCourseReceived(courses: List<CourseResponse>) {
                val courseList = mutableListOf<CourseEntity>()
                for (response in courses) {
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
                courseResult.postValue(courseList)
            }

        })

        return courseResult
    }

    override fun courseWithModules(courseId: String): LiveData<CourseEntity> {
        val courseResult = MutableLiveData<CourseEntity>()
        remoteDataSource.getAllCourse(object : RemoteDataSource.LoadCourseCallback{
            override fun onAllCourseReceived(courses: List<CourseResponse>) {
                lateinit var courseEntity: CourseEntity
                for (response in courses) {
                    if (response.id == courseId) {
                        courseEntity = CourseEntity(
                            response.id,
                            response.title,
                            response.description,
                            response.date,
                            false,
                            response.imagePath
                        )
                    }
                }
                courseResult.postValue(courseEntity)
            }

        })

        return courseResult
    }

    override fun allModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> {
        val moduleResult = MutableLiveData<List<ModuleEntity>>()
        remoteDataSource.getModules(courseId, object : RemoteDataSource.LoadModulesCallback{
            override fun onAllModulesReceived(module: List<ModuleResponse>) {
                val moduleList = mutableListOf<ModuleEntity>()
                for (response in module) {
                    val moduleEntity = ModuleEntity(
                        response.moduleId,
                        response.courseId,
                        response.title,
                        response.position,
                        false
                    )
                    moduleList.add(moduleEntity)
                }
                moduleResult.postValue(moduleList)
            }

        })

        return moduleResult
    }

    override fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity> {
        val moduleResult = MutableLiveData<ModuleEntity>()
        remoteDataSource.getModules(courseId, object : RemoteDataSource.LoadModulesCallback{
            override fun onAllModulesReceived(module: List<ModuleResponse>) {
                lateinit var moduleEntity: ModuleEntity
                for (response in module) {
                    if (response.moduleId == moduleId) {
                        moduleEntity = ModuleEntity(
                            response.moduleId,
                            response.courseId,
                            response.title,
                            response.position,
                            false
                        )
                        remoteDataSource.getContent(moduleId, object : RemoteDataSource.LoadContentCallback{
                            override fun onContentReceived(content: ContentResponse) {
                                moduleEntity.contentEntity = ContentEntity(content.content)
                                moduleResult.postValue(moduleEntity)
                            }

                        })
                        break
                    }
                }
            }

        })

        return moduleResult
    }
}