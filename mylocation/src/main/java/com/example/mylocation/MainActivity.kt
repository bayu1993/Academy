package com.example.mylocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylocation.presentation.adapter.WeatherAdapter
import com.example.mylocation.presentation.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = WeatherAdapter()

        rv_location.layoutManager = LinearLayoutManager(this)
        rv_location.adapter = adapter

        weatherViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[WeatherViewModel::class.java]

        btn_search.setOnClickListener {
            val city = et_location.text.toString()

            if (city.isEmpty()) return@setOnClickListener

            weatherViewModel.setWeather(city)
            showLoading(true)
        }

        weatherViewModel.getWeathers().observe(this, Observer { weatherItems ->
            if (weatherItems != null) {
                adapter.setData(weatherItems)
                showLoading(false)
            }else{
                Toast.makeText(this,"data kosong",Toast.LENGTH_SHORT).show()
                showLoading(false)
            }

        })

    }

    private fun showLoading(state: Boolean) {
        if (state) progress_weather.visibility = View.VISIBLE else progress_weather.visibility = View.GONE
    }
}
