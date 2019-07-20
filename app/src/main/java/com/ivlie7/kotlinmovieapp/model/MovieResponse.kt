package com.ivlie7.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
)