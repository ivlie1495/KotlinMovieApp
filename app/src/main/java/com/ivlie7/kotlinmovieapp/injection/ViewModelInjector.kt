package com.ivlie7.kotlinmovieapp.injection

import com.ivlie7.kotlinmovieapp.config.ApiConfig
import com.ivlie7.kotlinmovieapp.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApiConfig::class)])
interface ViewModelInjector {

    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun apiConfig(apiConfig: ApiConfig): Builder
    }
}