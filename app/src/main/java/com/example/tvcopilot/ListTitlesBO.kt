package com.example.tvcopilot

import com.google.gson.annotations.SerializedName

data class ListTitlesBO(

    @SerializedName("titles")
    val titles: List<TitlesBO>,

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_results")
    val results: Int,

    @SerializedName("total_pages")
    val totalPages: Int

    )
