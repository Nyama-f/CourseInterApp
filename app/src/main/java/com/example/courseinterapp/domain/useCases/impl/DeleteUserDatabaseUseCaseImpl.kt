package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.useCases.DeleteUserDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DeleteUserDatabaseUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository
): DeleteUserDatabaseUseCase {
    override fun invoke(user: User): Flow<Unit> =
        databaseRepository.deleteUser(user = user).flowOn(Dispatchers.IO)

}