package com.example.academy.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academy.R
import com.example.academy.data.ModuleEntity
import kotlinx.android.synthetic.main.items_module_list.view.*

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(module:ModuleEntity){
            with(itemView){
                text_module_title.text = module.title
            }
        }
    }

    private val listModule = ArrayList<ModuleEntity>()

    fun setModules(modules:List<ModuleEntity>?){
        if (modules==null) return
        listModule.clear()
        listModule.addAll(modules)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_module_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listModule.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listModule[position])
    }
}