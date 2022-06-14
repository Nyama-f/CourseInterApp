package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.useCases.GetUsersDatabaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersDatabaseUseCaseImpl @Inject constructor(
    private val databaseRepository: DatabaseRepository
): GetUsersDatabaseUseCase {

    override fun invoke(): Flow<List<User>>  = databaseRepository.getUsers()
}