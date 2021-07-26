package com.example.tvcopilot

import com.example.test_retrofit_setup.CountryBO
import retrofit2.http.GET

interface APIService {

    @GET("regions/?apiKey=aGy0jMb7mzGhpT7UJO9GucGkWDoVVw3vt9Yxnig6")//extended url
    fun getCountry (): retrofit2.Call<List<CountryBO>>

    @GET("genres/?apiKey=aGy0jMb7mzGhpT7UJO9GucGkWDoVVw3vt9Yxnig6")
    fun getGenre (): retrofit2.Call<List<GenreBO>>

}