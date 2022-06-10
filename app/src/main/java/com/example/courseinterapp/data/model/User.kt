package com.example.courseinterapp.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val userImage: String,
    val userEmail: String,
    val userId: String,
    val userName: String
){
    fun toUserApi() = UserApi(
        userImage = userImage,
        userEmail = userEmail,
        userId = userId,
        userName = userName
    )
}