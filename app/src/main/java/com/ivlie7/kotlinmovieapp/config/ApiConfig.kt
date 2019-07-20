package com.ivlie7.kotlinmovieapp.config

import com.ivlie7.kotlinmovieapp.constant.ApiConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        private val getInterceptor = Interceptor {chain ->
            val httpUrl = chain.request().url()
                .newBuilder()
                .addQueryParameter("api_key", ApiConstants.API_KEY)
                .addQueryParameter("language", "en-US")
                .build()

            val request = chain.request()
                .newBuilder()
                .url(httpUrl)
                .build()

            chain.proceed(request)
        }

        private val interceptorClient = OkHttpClient().newBuilder()
            .addInterceptor(getInterceptor)
            .build()

        fun getService(): Api {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(interceptorClient)
                .baseUrl(ApiConstants.API_URL)
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}
