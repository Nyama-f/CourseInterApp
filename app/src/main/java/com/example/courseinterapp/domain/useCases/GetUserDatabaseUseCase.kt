package com.example.courseinterapp.domain.useCases

import com.example.courseinterapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface GetUserDatabaseUseCase {

    operator fun invoke(userId: Int): Flow<User>
}