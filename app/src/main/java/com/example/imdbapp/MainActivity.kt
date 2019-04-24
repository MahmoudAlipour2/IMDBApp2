package com.example.imdbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.imdbapp.response.IMDBMovie
import com.squareup.picasso.Picasso
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


        btnGetMovieInfo.setOnClickListener {

            var imdbRequestInterface =
                RetrofitServiceGenerator.createService(RetrofitRequestInterface::class.java)
            imdbRequestInterface.getMovieInfo(etMovieName.text.toString(), Consts.API_KEY)
                .enqueue(object : retrofit2.Callback<IMDBMovie> {


                    override fun onResponse(call: Call<IMDBMovie>, response: Response<IMDBMovie>) {

                        tv_Name.text = response.body()?.title
                       tvYear.text = response.body()?.year
                       // tvGenre.text = response.body()?.genre
                        tvDirector.text = response.body()?.director
                        tvRate.text = response.body()?.imdbRating
                      //  tvWriter.text = response.body()?.writer
                        Picasso.get().load(response.body()?.poster).into(imgMoviePoster)
                    }

                    override fun onFailure(call: Call<IMDBMovie>, t: Throwable) {
                        Log.i("three","notok")
                        Toast.makeText(this@MainActivity, "Error fetching movie info", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        }



/*
btn_GetInfo.setOnClickListener(

)
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

*/


}}



