package com.ivlie7.kotlinmovieapp.ui.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ivlie7.kotlinmovieapp.R
import com.ivlie7.kotlinmovieapp.constant.ApiConstants
import com.ivlie7.kotlinmovieapp.model.Movie
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var movie: Movie

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        setData()
    }

    private fun setData() {
        movie = activity!!.intent.getParcelableExtra("movie")

        Glide.with(view!!.context).load(ApiConstants.API_POSTER + movie.posterPath).into(imageViewDetail)
        textViewTitleDetail.text = movie.title
        textViewReleaseDetail.text = movie.releaseDate
        textViewVote.text = movie.voteAverage.toString()
    }
}
