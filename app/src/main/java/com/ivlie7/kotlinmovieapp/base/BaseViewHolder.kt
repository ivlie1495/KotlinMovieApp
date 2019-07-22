package com.ivlie7.kotlinmovieapp.base

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.ivlie7.kotlinmovieapp.constant.API_POSTER
import com.ivlie7.kotlinmovieapp.model.Movie
import kotlinx.android.synthetic.main.custom_list.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindItem(movie: Movie, listener: (Movie) -> Unit) {
        itemView.textViewTitle.text = movie.title
        itemView.textViewRelease.text = movie.releaseDate
        Glide.with(itemView).load(API_POSTER + movie.posterPath).into(itemView.imageViewMovie)

        itemView.setOnClickListener {
            listener(movie)
        }
    }
}