package com.ivlie7.kotlinmovieapp.config

import com.ivlie7.kotlinmovieapp.model.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("movie/upcoming")
    fun getMovieList() : Observable<MovieResponse>
}