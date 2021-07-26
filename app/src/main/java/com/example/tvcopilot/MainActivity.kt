package com.example.tvcopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var retrofit: Retrofit
    lateinit var genreList: List<GenreBO>
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        spinner = findViewById(R.id.genre_spinner)

        retrofit = Retrofit.Builder()//
            .baseUrl( "https://api.watchmode.com/v1/")//base url
            .addConverterFactory(GsonConverterFactory.create())//converts with Gson --> needs some converter
            .build()

        val apiService = retrofit.create(APIService::class.java)//interface for APIService
        val apiList = apiService.getGenre()

        apiList.enqueue(object : Callback<List<GenreBO>> {//use callBack for multi threaded call
        override fun onFailure(call: Call<List<GenreBO>>, t: Throwable) {//is like error checking for failed response within network
            Log.e("ERROR", "FAILED")
        }

            override fun onResponse(call: Call<List<GenreBO>>, response: Response<List<GenreBO>>) {// if this is hit
                genreList = response.body()!!//needs null check  --> if respnse body null? id not continue

            }
        })
    }
}