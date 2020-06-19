package com.example.academy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.academy.R
import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.utils.DataDummy

import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.content_detail_course.*

class DetailCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        //val adapter = DetailCourseAdapter()
        val extras = intent.extras
        if (extras != null) {
            if (intent.hasExtra(EXTRA_MOVIE)) {
                supportActionBar?.title = "Detail ${getString(R.string.movie)}"
                val movieId = extras.getInt(EXTRA_MOVIE)
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }else if (intent.hasExtra(EXTRA_TV_SHOW)){
                supportActionBar?.title = "Detail ${getString(R.string.tv_show)}"
                val tvShowId = extras.getInt(EXTRA_TV_SHOW)
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow())
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        text_title.text = movie.title
        text_description.text = movie.overview
        tv_popular.text = movie.popularity.toString()
        text_date.text = DataDummy.getDisplayDate(movie.release_date)
        Glide.with(this)
            .load(movie.poster_path)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(image_poster)
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        text_title.text = tvShow.name
        text_description.text = tvShow.overview
        tv_popular.text = tvShow.popularity.toString()
        text_date.text = DataDummy.getDisplayDate(tvShow.first_air_date)
        Glide.with(this)
            .load(tvShow.poster_path)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(image_poster)
    }

    companion object {
        const val EXTRA_TV_SHOW = "EXTRA_TV_SHOW"
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }

}
