package com.example.courseinterapp.domain.repository

import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.data.model.UserApi
import kotlinx.coroutines.flow.Flow

interface ApiRepository {

    fun getUsers(): Flow<List<UserApi>>

    fun addUser(userApi: UserApi)

}