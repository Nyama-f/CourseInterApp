package com.example.courseinterapp.domain.useCases

import com.example.courseinterapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface GetUsersDatabaseUseCase {

    operator fun invoke(): Flow<List<User>>
}