package com.example.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.academy.utils.DataDummy

class TvShowViewModel:ViewModel() {
    fun getTvShow() = DataDummy.generateDummyTvShow()
}