package com.example.mylocation.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylocation.R
import com.example.mylocation.data.Weather
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherAdapter() :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private val weatherList = mutableListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        )
    }

    fun setData(data: MutableList<Weather>) {
        weatherList.clear()
        weatherList.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return weatherList?.size ?: 0
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        holder.bind(weatherList?.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Weather?) {
            itemView.tv_name.text = data?.name
            itemView.tv_temp.text = data?.temperature
            itemView.tv_desc.text = data?.description
        }
    }

}