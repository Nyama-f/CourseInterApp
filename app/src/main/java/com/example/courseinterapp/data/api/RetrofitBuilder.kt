package com.example.courseinterapp.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitBuilder {

    @Provides
    fun provideApiService(): ApiService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)

    companion object {
        private const val BASE_URL = "https://62a226f1cc8c0118ef5de9a6.mockapi.io/"
    }
}