package com.example.tvcopilot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
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
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {//? can be nullable
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        spinner = findViewById(R.id.genre_spinner)
        button = findViewById(R.id.searchButton)

        button.setOnClickListener {
            val genre = spinner.selectedItem as GenreBO
            val intent = Intent(this, Suggestions:: class.java).apply {
                putExtra("EXTRA", genre.id)
            }
            startActivity(intent)
        }

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
                arrayAdapter()
    }
})
    }
    fun arrayAdapter(){
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genreList)//look into overriding simple style
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

}
