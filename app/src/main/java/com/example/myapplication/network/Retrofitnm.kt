package com.example.myapplication.network

import com.example.myapplication.app.App
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofitnm {

    // todo add suspend fun -> launch from page1ViewModel
    companion object {
        private val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var newRequest = chain.request()
                    val url = newRequest.url.newBuilder()
                        .addQueryParameter("apiKey", App.API_KEY).build()
                    newRequest = newRequest.newBuilder().url(url).build()
                    chain.proceed(newRequest)
                }
                .addInterceptor(HttpLoggingInterceptor().also { it ->
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
        }
    }

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(App.URL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun serviceSeries(): SearchService {
        return retrofit.create(SearchService::class.java)
    }
}