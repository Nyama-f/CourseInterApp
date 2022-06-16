package com.example.courseinterapp.domain.useCases

import com.example.courseinterapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface DeleteUserDatabaseUseCase {

    operator fun invoke(user: User): Flow<Unit>
}