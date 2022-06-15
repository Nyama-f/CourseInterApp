package com.example.courseinterapp.domain.useCases

import com.example.courseinterapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface InsertUsersDatabaseUseCase {

    operator fun invoke(users: List<User>): Flow<Unit>
}