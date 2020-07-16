package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.livedata.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        subscribe()
    }

    private fun subscribe(){
        val elapseTimeObserver = Observer<Long?>{
            val txt = this@MainActivity.resources.getString(R.string.seconds, it)
            tv_timer.text = txt
        }

        mainViewModel.getElapseTime().observe(this, elapseTimeObserver)
    }
}
