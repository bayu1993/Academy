package com.example.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.academy.data.CourseEntity
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.utils.DataDummy

class BookmarkViewModel(private val repo:AcademyRepository):ViewModel() {
    fun getBookmarks() : LiveData<List<CourseEntity>> = repo.getBookmarkedCourses()
}