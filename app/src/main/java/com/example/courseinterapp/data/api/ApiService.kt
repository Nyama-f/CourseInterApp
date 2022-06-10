package com.example.courseinterapp.data.api

import com.example.courseinterapp.data.model.UserApi
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<UserApi>
}