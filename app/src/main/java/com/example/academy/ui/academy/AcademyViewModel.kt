package com.example.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.CourseEntity
import com.example.academy.data.sources.AcademyRepository

class AcademyViewModel(private val repo:AcademyRepository): ViewModel() {

    fun getCourses() : LiveData<List<CourseEntity>> = repo.getAllCourses()
}