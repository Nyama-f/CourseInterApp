package com.example.courseinterapp.domain.repositories.impl

import com.example.courseinterapp.data.database.UserDao
import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): DatabaseRepository {

    override fun getUsers(): Flow<List<User>>  = flow {
        val users = userDao.getUsers().map { it.toUser() }
        emit(users)
    }

    override fun getUser(userId: Int): Flow<User>  = flow {
        val user = userDao.getUser(userId).toUser()
        emit(user)
    }

    override fun insertUser(user: User): Flow<Unit> = flow {
        userDao.insertUser(user.toUserEntity())
    }

    override fun insertUsers(users: List<User>): Flow<Unit> = flow{
        val users = users.map{ it.toUserEntity() }
        userDao.insertUsers(users)
    }

    override fun deleteUser(user: User): Flow<Unit>  = flow{
        userDao.deleteUser(user.toUserEntity())
    }
}