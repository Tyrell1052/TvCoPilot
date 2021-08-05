package com.example.tvcopilot

import com.google.gson.annotations.SerializedName

data class TitlesBO(

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("year")
    val year: Int
)
