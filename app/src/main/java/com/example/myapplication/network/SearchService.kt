package com.example.myapplication.network

import com.example.myapplication.data.MovieProperty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("/default.aspx")
    fun searchSeriesByName(@Query("t") title: String): Call<MovieProperty>
}