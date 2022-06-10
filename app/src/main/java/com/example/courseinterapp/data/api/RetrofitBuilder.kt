package com.example.courseinterapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {


    fun provideApiService(): ApiService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)

    companion object {
        private const val BASE_URL = "https://628913bb7af826e39e6870bc.mockapi.io/"
    }
}