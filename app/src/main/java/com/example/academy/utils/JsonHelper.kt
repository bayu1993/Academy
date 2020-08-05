package com.example.academy.utils

import android.content.Context
import com.example.academy.data.sources.remote.response.MovieResponse
import com.example.academy.data.sources.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovieList(): MutableList<MovieResponse> {
        val list = mutableListOf<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieList.json").toString())
            val result = responseObject.getJSONArray("results")
            for (i in 0 until result.length()) {
                val movie = result.getJSONObject(i)
                val id = movie.getInt("id")
                val overview = movie.getString("overview")
                val popularity = movie.getDouble("popularity")
                val posterPath = movie.getString("poster_path")
                val title = movie.getString("title")
                val releaseDate = movie.getString("release_date")
                val movieResponse =
                    MovieResponse(id, overview, popularity, posterPath, title, releaseDate)
                list.add(movieResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvList(): MutableList<TvShowResponse> {
        val list = mutableListOf<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowList.json").toString())
            val result = responseObject.getJSONArray("results")
            for (i in 0 until result.length()) {
                val tvShow = result.getJSONObject(i)
                val id = tvShow.getInt("id")
                val overview = tvShow.getString("overview")
                val name = tvShow.getString("name")
                val posterPath = tvShow.getString("poster_path")
                val firstAirDate = tvShow.getString("first_air_date")
                val popularity = tvShow.getDouble("popularity")
                val tvShowResponse =
                    TvShowResponse(id, name, overview, popularity, posterPath, firstAirDate)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}