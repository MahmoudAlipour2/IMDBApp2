package com.example.imdbapp

import com.example.imdbapp.response.IMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitRequestInterface {
    @GET("/")
    fun getMovieInfo(@Query("t") movieName: String, @Query("apikey") apiKey: String) : Call<IMDBMovie>


}