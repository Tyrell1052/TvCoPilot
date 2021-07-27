package com.example.tvcopilot

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class TitlesBO(

    @SerializedName("page")
    val page: String,

    @SerializedName("titles")
    val titles: List<CaseMap.Title>,

    @SerializedName("total_pages")
    val total_pages: String,

    @SerializedName("total_results")
    val total_results: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("imdb_id")
    val imdb_id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("tmdb_id")
    val tmdb_id: Int,

    @SerializedName("tmdb_type")
    val tmdb_type: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("year")
    val year: Int
)