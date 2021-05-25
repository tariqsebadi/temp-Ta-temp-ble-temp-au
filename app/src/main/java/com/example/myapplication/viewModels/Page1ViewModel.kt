package com.example.myapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieProperty
import kotlinx.coroutines.launch
import java.lang.Exception

class Page1ViewModel:ViewModel() {
    private val _response = MutableLiveData<String>()
    private val _movieProperty = MutableLiveData<List<MovieProperty>>()


    val response: LiveData<String>
    get() = _response

    val movieProperty: LiveData<List<MovieProperty>>
        get() = movieProperty

    init {
        searchMovies()
    }

    private fun searchMovies() {
//        //todo response stuff
//        viewModelScope.launch {
//            try {
//            }
//            catch (e: Exception) {
//            }
//        }
    }
}