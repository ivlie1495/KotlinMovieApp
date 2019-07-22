package com.ivlie7.kotlinmovieapp.ui.main

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ivlie7.kotlinmovieapp.base.BaseViewModel
import com.ivlie7.kotlinmovieapp.config.ApiConfig
import com.ivlie7.kotlinmovieapp.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel() {

    private val call = ApiConfig.getService().getMovieList()
    var moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getMovieList(): LiveData<List<Movie>>? {
        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                moviesLiveData.value = it.movies
            }
        return moviesLiveData
    }
}
