package com.example.courseinterapp.data.api

import com.example.courseinterapp.data.model.UserApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("user")
    suspend fun getUsers(): List<UserApi>

    @POST("user")
    suspend fun addUser(@Body userApi: UserApi)
}