package com.example.mylocation.presentation.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylocation.data.Weather
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception
import java.text.DecimalFormat

class WeatherViewModel : ViewModel() {
    companion object {
        const val API_KEY = "5f25841af62d9487da68ecd569fdac27"
    }

    private val listWeather = MutableLiveData<MutableList<Weather>>()

    internal fun setWeather(cities: String) {
        val client = AsyncHttpClient()
        val listItem = mutableListOf<Weather>()
        val url =
            "https://api.openweathermap.org/data/2.5/group?id=$cities&units=metric&appid=$API_KEY"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                try {
                    val result = responseBody?.let { String(it) }
                    val responseObect = JSONObject(result)
                    val list = responseObect.getJSONArray("list")

                    for (i in 0 until list.length()) {
                        val weather = list.getJSONObject(i)
                        val tempInK = weather.getJSONObject("main").getDouble("temp")
                        val tempInC = tempInK - 273
                        val temp = DecimalFormat("##.##").format(tempInC)
                        val weatherItem = Weather(
                            id = weather.getInt("id"),
                            name = weather.getString("name"),
                            currentWeather = weather.getJSONArray("weather").getJSONObject(0)
                                .getString("main"),
                            description = weather.getJSONArray("weather").getJSONObject(0)
                                .getString("description"),
                            temperature = temp
                        )
                        listItem.add(weatherItem)
                    }

                } catch (e: Exception) {
                    Log.d("onFailure", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.e("onFailure", error?.localizedMessage)
            }

        })
    }

    internal fun getWeathers(): LiveData<MutableList<Weather>> {
        return listWeather
    }
}