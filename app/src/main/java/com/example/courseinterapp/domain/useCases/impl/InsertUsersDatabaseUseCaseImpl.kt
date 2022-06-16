package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.useCases.InsertUsersDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InsertUsersDatabaseUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository
): InsertUsersDatabaseUseCase {
    override fun invoke(users: List<User>): Flow<Unit> =
        databaseRepository.insertUsers(users).flowOn(Dispatchers.IO)
}