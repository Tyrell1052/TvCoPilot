package com.example.tvcopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PreviousMoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_movies)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)//<> is the cast type

        val list = ArrayList<TitlesBO>()
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))
        list.add(TitlesBO("Avengers", "Action", 2018))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ListTitlesAdapter(list)

        recyclerView.adapter = adapter




    }
}