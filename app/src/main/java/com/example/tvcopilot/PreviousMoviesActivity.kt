package com.example.tvcopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvcopilot.databinding.ActivityPreviousMoviesBinding
//import kotlinx.android.synthetic.main.activity_privious_movies.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream



class PreviousMoviesActivity : AppCompatActivity() {

     private lateinit var titlesListAdapter: ListTitlesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_movies)

        initRecyclerView()
        addDataSet()


    }



    private fun addDataSet(){
        val data = DataSource.createDataSet()
        titlesListAdapter.submitList(data)
    }


    private fun initRecyclerView(){

        recycler_view.apply {
             layoutManager = LinearLayoutManager(this@PreviousMoviesActivity)
//            val topSpacingDecorator = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecorator)
            titlesListAdapter = ListTitlesAdapter()
            var adapter = titlesListAdapter
        }
    }

}