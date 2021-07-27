package com.example.tvcopilot

import com.google.gson.annotations.SerializedName

data class GenreBO(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("tmdb_id")
    val tmdbId: String,

){
    override fun toString(): String {
        return name

    }
}


//only use int if i am going to be adding numbers