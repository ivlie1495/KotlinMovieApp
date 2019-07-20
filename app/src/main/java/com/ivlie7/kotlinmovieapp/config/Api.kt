package com.ivlie7.kotlinmovieapp.config

import com.ivlie7.kotlinmovieapp.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie/upcoming")
    fun getMovieList() : Call<MovieResponse>
}