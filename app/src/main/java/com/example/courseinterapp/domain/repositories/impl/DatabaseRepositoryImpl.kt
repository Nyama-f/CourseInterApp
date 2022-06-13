package com.example.courseinterapp.domain.repositories.impl

import com.example.courseinterapp.data.database.UserDao
import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val userDAO: UserDao
): DatabaseRepository {

    override fun getUsers(): Flow<List<User>> {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: Int): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun insertUser(user: User): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override fun insertUsers(users: List<User>): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteUser(user: User): Flow<Unit> {
        TODO("Not yet implemented")
    }
}