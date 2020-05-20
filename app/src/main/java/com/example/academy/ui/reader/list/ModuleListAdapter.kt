package com.example.academy.ui.reader.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.academy.R
import com.example.academy.data.ModuleEntity

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textTitle: TextView = itemView.findViewById(R.id.text_module_title)
        fun bind(moduleEntity: ModuleEntity) {
            textTitle.text = moduleEntity.title
        }
    }

    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_module_list_custom, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listModules.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listModules[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, listModules[position].moduleId)
        }
    }
}