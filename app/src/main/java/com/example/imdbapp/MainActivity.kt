package com.example.imdbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.imdbapp.response.IMDBMovie
import kotlinx.android.synthetic.main.activity_imdb.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_IMDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var requestInterface = RetrofitServiceGenerator.createService(RetrofitRequestInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

btn_GetInfo.setOnClickListener()
        requestInterface.imdbMovie().enqueue(object : Callback<List<IMDBMovie>> {
            override fun onFailure(call: Call<List<IMDBMovie>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<IMDBMovie>>, response: Response<List<IMDBMovie>>) {
                val imdbRate = response.body()?.get(0)?.imdbRating.toString()
                val title = response.body()?.get(0)?.title.toString()

                tv_IMDB2.text = imdbRate
                tv_Name2.text = title
            }
        })



}}



