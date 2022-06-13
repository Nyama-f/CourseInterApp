package com.example.courseinterapp.domain.useCases

import com.example.courseinterapp.data.model.UserApi
import kotlinx.coroutines.flow.Flow


interface GetUsersUseCase {

    operator fun invoke(): Flow<List<UserApi>>
}