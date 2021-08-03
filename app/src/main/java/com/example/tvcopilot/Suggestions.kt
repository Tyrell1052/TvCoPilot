package com.example.tvcopilot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Suggestions : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var yearTextView: TextView
    lateinit var typeTextView: TextView
    lateinit var retrofit: Retrofit
    lateinit var listTitles: List<TitlesBO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestions)

        titleTextView = findViewById(R.id.titleTextView)
        yearTextView = findViewById(R.id.yearTextView)
        typeTextView = findViewById(R.id.typeTextView)

        val message = intent.getStringExtra("EXTRA")

        retrofit = Retrofit.Builder()//
            .baseUrl( "https://api.watchmode.com/v1/")//base url
            .addConverterFactory(GsonConverterFactory.create())//converts with Gson --> needs some converter
            .build()

        val apiService = retrofit.create(APIService::class.java)//interface for APIService
        val apiList = apiService.getTitles(message.toString())

        apiList.enqueue(object : Callback<ListTitlesBO> {//use callBack for multi threaded call
        override fun onFailure(call: Call<ListTitlesBO>, t: Throwable) {//is like error checking for failed response within network
            Log.e("ERROR", "FAILED")
        }

            override fun onResponse(call: Call<ListTitlesBO>, response: Response<ListTitlesBO>) {// if this is hit
                listTitles = response.body()?.titles?: emptyList()//needs null check  --> if respnse body null? id not continue
                val random = listTitles.random()
                titleTextView.text = random.title
                yearTextView.text = random.year.toString()
                typeTextView.text = random.type
            }
        })

//        fun showData(movie: List<ListTitlesBO>){
//            recyclerView.apply{
//                layoutManager = LinearLayoutManager(this@Suggestions)
//                adapter = ListTitlesAdapter
//            }
//        }
    }
}