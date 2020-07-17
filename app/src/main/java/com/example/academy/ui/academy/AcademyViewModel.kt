package com.example.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.CourseEntity
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.utils.DataDummy

class AcademyViewModel(private val repo:AcademyRepository): ViewModel() {

    fun getCourses() : LiveData<List<CourseEntity>> = repo.getAllCourses()
}