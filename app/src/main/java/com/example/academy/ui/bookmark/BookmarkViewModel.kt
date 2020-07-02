package com.example.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.utils.DataDummy

class BookmarkViewModel(private val repo:AcademyRepository):ViewModel() {
    fun getBookmarks() = repo.getBookmarkedCourses()
}