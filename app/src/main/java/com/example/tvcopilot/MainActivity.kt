package com.example.tvcopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.test_retrofit_setup.APIService
import com.example.test_retrofit_setup.CountryBO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var retrofit: Retrofit
    lateinit var countryList: List<CountryBO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

        retrofit = Retrofit.Builder()//
            .baseUrl( "https://api.watchmode.com/v1/")//base url
            .addConverterFactory(GsonConverterFactory.create())//converts with Gson --> needs some converter
            .build()

        val apiService = retrofit.create(APIService::class.java)//interface for APIService
        val apiList = apiService.getCountry()

        apiList.enqueue(object : Callback<List<CountryBO>> {//use callBack for multi threaded call
        override fun onFailure(call: Call<List<CountryBO>>, t: Throwable) {//is like error checking for failed response within network
            Log.e("ERROR", "FAILED")
        }

            override fun onResponse(call: Call<List<CountryBO>>, response: Response<List<CountryBO>>) {// if this is hit
                countryList = response.body()!!//needs null check  --> if respnse body null? id not continue

                for(country in countryList){//
                    var content = ""
                    content += country.country + "\n"
                    content += country.name + "\n"
                    content += country.flagPicture + "\n\n"
                    content += country.country + "\n"
                    content += country.name + "\n"
                    content += country.flagPicture + "\n\n"
                    content += country.country + "\n"
                    content += country.name + "\n"
                    content += country.flagPicture + "\n\n"

                    textView.append(content)


                }
            }


        })
    }




}