package com.example.test_retrofit_setup

import com.google.gson.annotations.SerializedName


data class NetworksBO(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    //@SerializedName("regions")
    // val availableRegions: List<>,

)
