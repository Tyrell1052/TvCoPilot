package com.example.tvcopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity.apply
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvcopilot.databinding.ActivityPreviousMoviesBinding
import kotlinx.android.synthetic.main.PreviousMovies.*


class PreviousMovies : AppCompatActivity() {

     lateinit var titlesListAdapter: ListTitlesAdapter


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

        ActivityPreviousMoviesBinding.apply {
             RecyclerView.LayoutManager = LinearLayoutManager(this@PreviousMovies)
//            val topSpacingDecorator = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecorator)
            titlesListAdapter = ListTitlesAdapter()
            var adapter = titlesListAdapter
        }
    }

}