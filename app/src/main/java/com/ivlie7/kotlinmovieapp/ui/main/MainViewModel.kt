package com.ivlie7.kotlinmovieapp.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ivlie7.kotlinmovieapp.config.ApiConfig
import com.ivlie7.kotlinmovieapp.model.Movie
import com.ivlie7.kotlinmovieapp.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val call = ApiConfig.getService().getMovieList()
    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovieList(): LiveData<List<Movie>>? {
        call.enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movies:List<Movie>? = response.body()?.movies
                moviesLiveData.value = movies
            }
        })
        return moviesLiveData
    }
}
