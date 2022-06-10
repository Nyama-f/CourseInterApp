package com.example.courseinterapp.domain.useCases.impl

import com.example.courseinterapp.data.model.UserApi
import com.example.courseinterapp.domain.repository.ApiRepository
import com.example.courseinterapp.domain.useCases.AddUserUseCase
import javax.inject.Inject

class AddUserUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository,
) : AddUserUseCase {

    override fun invoke(userApi: UserApi) = apiRepository.addUser(userApi = userApi)

}