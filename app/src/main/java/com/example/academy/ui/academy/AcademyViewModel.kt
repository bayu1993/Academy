package com.example.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.example.academy.utils.DataDummy

class AcademyViewModel: ViewModel() {

    fun getCourses() = DataDummy.generateDummyCourses()
}