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
        list.add(TitlesBO("Avengers", "Movie", 2009))
        list.add(TitlesBO("Lion King", "Movie", 1994))
        list.add(TitlesBO("Bonnie and Clyde", "Movie", 1967))
        list.add(TitlesBO("Avatar", "Tv Series", 2009))
        list.add(TitlesBO("Silicon Valley", "Tv Series", 2014))
        list.add(TitlesBO("Inception", "Movie", 2010))
        list.add(TitlesBO("The Lord of the Rings: The Return of the King", "Movie", 2003))
        list.add(TitlesBO("Braveheart", "Action", 1995))
        list.add(TitlesBO("Up", "Movie", 2018))
        list.add(TitlesBO("Rocky", "Movie", 2018))
        list.add(TitlesBO("Slumdog Millionaire", "Movie", 2008))
        list.add(TitlesBO("Family Guy", "Tv Series", 1999))
        list.add(TitlesBO("24", "Tv Series", 2001))
        list.add(TitlesBO("The Office", "Tv Series", 2005))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ListTitlesAdapter(list)

        recyclerView.adapter = adapter




    }
}