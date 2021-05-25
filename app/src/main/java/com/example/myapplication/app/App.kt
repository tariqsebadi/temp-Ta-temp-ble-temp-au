package com.example.myapplication.app

import android.app.Application

class App() : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        val URL_API = "https://www.omdbapi.com/"
        val API_KEY = "47a7deb1"

        private var instance: App? = null

        fun getInstance(): App?{
            return instance
        }
    }
}