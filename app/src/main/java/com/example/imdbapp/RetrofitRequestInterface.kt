package com.example.imdbapp

import com.example.imdbapp.response.IMDBMovie
import retrofit2.Call
import retrofit2.http.GET



interface RetrofitRequestInterface {
    @GET("t=star&apikey=77d67210")
    fun imdbMovie(): Call<IMDBMovie>


}