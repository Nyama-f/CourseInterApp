package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.User

import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.useCases.GetUserDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserDatabaseUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository
): GetUserDatabaseUseCase {
    override fun invoke(userId: Int): Flow<User> {
        val user = databaseRepository.getUser(userId = userId).flowOn(Dispatchers.IO)
        return user
    }
}
