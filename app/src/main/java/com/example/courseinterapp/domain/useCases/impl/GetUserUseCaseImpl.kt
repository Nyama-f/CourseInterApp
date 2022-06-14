package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.UserApi
import com.example.courseinterapp.domain.repository.ApiRepository
import com.example.courseinterapp.domain.useCases.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUsersUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository,
) : GetUsersUseCase {

    override fun invoke(): Flow<List<UserApi>> = apiRepository.getUsers().flowOn(Dispatchers.IO)

}