package com.example.courseinterapp.domain.repositories

import com.example.courseinterapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getUsers(): Flow<List<User>>

    fun getUser(userId: Int): Flow<User>

    fun insertUser(user: User): Flow<Unit>

    fun insertUsers(users: List<User>): Flow<Unit>

    fun deleteUser(user: User): Flow<Unit>
}