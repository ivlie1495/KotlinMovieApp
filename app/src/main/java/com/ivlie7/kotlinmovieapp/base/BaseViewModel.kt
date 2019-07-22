package com.ivlie7.kotlinmovieapp.base

import android.arch.lifecycle.ViewModel
import com.ivlie7.kotlinmovieapp.config.ApiConfig
import com.ivlie7.kotlinmovieapp.injection.DaggerViewModelInjector
import com.ivlie7.kotlinmovieapp.injection.ViewModelInjector
import com.ivlie7.kotlinmovieapp.ui.main.MainViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .apiConfig(ApiConfig)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }
}