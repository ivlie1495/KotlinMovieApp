package com.ivlie7.kotlinmovieapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ivlie7.kotlinmovieapp.R
import com.ivlie7.kotlinmovieapp.base.MovieViewHolder
import com.ivlie7.kotlinmovieapp.model.Movie

class MovieAdapter(private val context: Context,
                   private var movies: List<Movie>?,
                   private val listener: (Movie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false))

    override fun getItemCount(): Int = movies?.size!!

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movies?.get(position)!!, listener)
    }
}
