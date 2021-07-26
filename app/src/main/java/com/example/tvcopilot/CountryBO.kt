package com.example.TvCoPilot

import com.google.gson.annotations.SerializedName

data class CountryBO(
    @SerializedName("country")//raw from api
    val country: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("flag")
    val flagPicture: String
)
