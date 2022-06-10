package com.example.courseinterapp.data.repository

import com.example.courseinterapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}