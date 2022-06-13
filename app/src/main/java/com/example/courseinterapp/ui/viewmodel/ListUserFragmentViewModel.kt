package com.example.courseinterapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseinterapp.data.model.User
import com.example.courseinterapp.domain.useCases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserFragmentViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(listOf())
    val users = _users.asStateFlow()

//    private val _user = MutableStateFlow<User?>(null)
//    val user = _user.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("Exception", throwable.toString())
    }

    fun getUsers() {
        viewModelScope.launch(exceptionHandler) {
            getUsersUseCase.invoke()
                .map { users ->
                    users.map { it.toUser() }
                }
                .filterNotNull()
                .collect {
                    _users.emit(it)
                }
        }
    }

}