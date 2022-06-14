package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.useCases.InsertUserDatabaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertUserDatabaseUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository
): InsertUserDatabaseUseCase {

    override fun invoke(user: User): Flow<Unit> = databaseRepository.insertUser(user)

}