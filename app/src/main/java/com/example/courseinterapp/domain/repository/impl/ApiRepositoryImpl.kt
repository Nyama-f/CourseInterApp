package com.example.courseinterapp.domain.repository.impl

import com.example.courseinterapp.data.api.ApiService
import com.example.courseinterapp.data.model.UserApi
import com.example.courseinterapp.domain.repository.ApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepository {

    override fun getUsers(): Flow<List<UserApi>> = flow {
        val api = apiService.getUsers()
        emit(api)
    }

    override fun addUser(userApi: UserApi) {
        CoroutineScope(Dispatchers.IO).launch{
            apiService.addUser(userApi)
        }
    }
}