package com.example.academy.utils.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.academy.data.sources.AcademyRepository
import com.example.academy.di.Injection
import com.example.academy.ui.academy.AcademyViewModel
import com.example.academy.ui.bookmark.BookmarkViewModel
import com.example.academy.ui.detail.DetailCourseViewModel
import com.example.academy.ui.reader.CourseReaderViewModel

class ViewModelFactory private constructor(private val repo: AcademyRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                AcademyViewModel(repo) as T
            }
            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                DetailCourseViewModel(repo) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(repo) as T
            }
            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                CourseReaderViewModel(repo) as T
            }
            else -> throw Throwable("Unknow view model class: "+modelClass.name)
        }
    }
}