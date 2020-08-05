package com.example.academy.data.sources.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val title: String,
    val release_date: String
): Parcelable