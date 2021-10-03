package com.amnk.wassmatest.app

import com.amnk.wassmatest.BuildConfig
import com.amnk.wassmatest.data.api.WasApi
import com.amnk.wassmatest.data.api.RemoteRepository
import com.amnk.wassmatest.data.api.Repository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiInjection {

    fun provideRepository() : Repository = RemoteRepository


    private var APIBaseUrl = "https://jsonplaceholder.typicode.com/"
    private fun provideRetroFit() : Retrofit {
        return  Retrofit.
        Builder().
        baseUrl(APIBaseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        client(provideOkHttpClient()).
        build()
    }

    private fun provideOkHttpClient () : OkHttpClient
    {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(provideLoggingInterceptor())
        return httpClient.build()
    }

    private fun provideLoggingInterceptor() : HttpLoggingInterceptor
    {
        val logging = HttpLoggingInterceptor()
        logging.level =if (BuildConfig.DEBUG)
        {
            HttpLoggingInterceptor.Level.BODY
            HttpLoggingInterceptor.Level.HEADERS

        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    fun provideWasApi(): WasApi
    {
        return provideRetroFit().create(WasApi::class.java)
    }

}