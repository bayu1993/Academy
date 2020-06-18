package com.example.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.academy.R
import com.example.academy.data.CourseEntity
import com.example.academy.ui.reader.CourseReaderActivity

import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.content_detail_course.*

class DetailCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        //val adapter = DetailCourseAdapter()
        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != null){
                viewModel.setSelectedMovie(movieId)
                //val modules = viewModel.getModules()
                //adapter.setModules(modules)
                populateMovie(viewModel.getMovie())
            }
        }
    }

    private fun populateMovie(course: CourseEntity){
        text_title.text = course.title
        text_desc.text = course.description
        text_date.text = resources.getString(R.string.deadline_date, course.deadline)
        Glide.with(this)
            .load(course.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(image_poster)
        btn_start.setOnClickListener {
            val intent = Intent(this,CourseReaderActivity::class.java).apply {
                putExtra(CourseReaderActivity.EXTRA_COURSE_ID, course.courseId)
            }
            startActivity(intent)
        }
    }

    companion object{
        const val EXTRA_TV_SHOW = "EXTRA_TV_SHOW"
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }

}
