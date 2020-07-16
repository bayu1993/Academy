package com.example.livedata.viewmodel

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    companion object{
        private const val ONE_SECOND = 1000
    }

    private val mInitialTime: Long
    private val mElapseTime = MutableLiveData<Long?>()

    init {
        mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                val value = (SystemClock.elapsedRealtime()-mInitialTime) / 1000
                mElapseTime.postValue(value)
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    fun getElapseTime(): LiveData<Long?>{
        return mElapseTime
    }
}