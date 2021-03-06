package com.example.imdbapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object RetrofitServiceGenerator {
    val API_BASE_URL = Consts.IMDB_WEBSERVICE_BASE_URL
    val httpClient = OkHttpClient.Builder().build()
    val builder = Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient).build()
        return retrofit.create(serviceClass)
    }


/*        var BASE_URL = "http://www.omdbapi.com/?"
        private val httpClient = OkHttpClient.Builder().build()
        private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        fun <S> createService(serviceClass: Class<S>): S {
            val retrofit = builder.client(httpClient).build()
            return retrofit.create(serviceClass)
        }*/
    }

    //tarife Retrofit (One)
   /* fun getClient(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }*/


