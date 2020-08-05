package com.example.academy.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.academy.BuildConfig
import com.example.academy.R
import com.example.academy.data.TvShowEntity
import com.example.academy.ui.detail.DetailCourseActivity
import com.example.academy.utils.DataDummy
import kotlinx.android.synthetic.main.items_bookmark.view.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private var tvShowList = ArrayList<TvShowEntity>()

    fun setCourseList(tvShows: List<TvShowEntity>?) {
        if (tvShows == null) return
        tvShowList.clear()
        tvShowList.addAll(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_bookmark, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowEntity) {
            with(itemView) {
                tv_item_title.text = tvShow.name
                tv_item_description.text = tvShow.popularity.toString()
                tv_item_date.text = DataDummy.getDisplayDate(tvShow.first_air_date)
                setOnClickListener {
                    val intent = Intent(context, DetailCourseActivity::class.java).apply {
                        putExtra(DetailCourseActivity.EXTRA_TV_SHOW, tvShow.id)
                    }

                    context.startActivity(intent)
                }
//                img_share.setOnClickListener { callback.onShareClick(tvShow) }
                Glide.with(context)
                    .load("${BuildConfig.BASE_URL}${tvShow.poster_path}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(img_poster)
            }
        }
    }
}