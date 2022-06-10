package com.example.courseinterapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.courseinterapp.data.model.UserApi
import com.example.courseinterapp.domain.useCases.AddUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddUserFragmentViewModel @Inject constructor(private val addUserUseCase: AddUserUseCase): ViewModel() {

    fun addUser(inputName: String?, inputEmail: String?){
        val name = parseString(inputName)
        val email = parseString(inputEmail)
        val fieldsValid = validateInput(name, email)
        if(fieldsValid){
            addUserUseCase.invoke(UserApi("", email, null, name))
        }
    }

    fun parseString(inputString: String?): String{
        return inputString?.trim() ?: ""
    }

    private fun validateInput(name: String, email: String): Boolean{
        var result = true
        if(name.isBlank() || email.isBlank()) result = false
        return result
    }
}
