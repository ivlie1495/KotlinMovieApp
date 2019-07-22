package com.ivlie7.kotlinmovieapp.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivlie7.kotlinmovieapp.DetailActivity
import com.ivlie7.kotlinmovieapp.R
import com.ivlie7.kotlinmovieapp.adapter.MovieAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.support.v4.intentFor

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getMovieList().observe(this, Observer {
            movies ->
            movieAdapter = MovieAdapter(view?.context!!, movies) {
                startActivity(intentFor<DetailActivity>("movie" to it).singleTop())
            }
            recyclerView.adapter = movieAdapter
        })
    }
}
