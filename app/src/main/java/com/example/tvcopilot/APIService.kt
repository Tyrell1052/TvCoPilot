package com.example.tvcopilot

//import com.example.TvCoPilot.TitlesBO
//import com.example.test_retrofit_setup.CountryBO
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

//    @GET("regions/?apiKey=aGy0jMb7mzGhpT7UJO9GucGkWDoVVw3vt9Yxnig6")//extended url
//    fun getCountry (): retrofit2.Call<List<CountryBO>>

    @GET("genres/?apiKey=aGy0jMb7mzGhpT7UJO9GucGkWDoVVw3vt9Yxnig6")
    fun getGenre (): retrofit2.Call<List<GenreBO>>

    @GET("list-titles/?apiKey=aGy0jMb7mzGhpT7UJO9GucGkWDoVVw3vt9Yxnig6")//&genres= 32
    fun getTitles (@Query("genres") genre: String): retrofit2.Call<ListTitlesBO>







}