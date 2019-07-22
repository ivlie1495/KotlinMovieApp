package com.ivlie7.kotlinmovieapp.ui.main

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.ivlie7.kotlinmovieapp.base.BaseViewModel
import com.ivlie7.kotlinmovieapp.config.Api
import com.ivlie7.kotlinmovieapp.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var api: Api
    var moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getMovieList(): MutableLiveData<List<Movie>> {
        api.getMovieList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                moviesLiveData.value = it.movies
            }
        return moviesLiveData
    }
}
