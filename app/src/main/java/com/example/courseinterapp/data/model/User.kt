package com.example.courseinterapp.data.model

data class User(
    val userImage: String,
    val userEmail: String,
    val userId: String,
    val userName: String,
) {
    fun toUserEntity() = UserEntity(
        userImage = userImage,
        userEmail = userEmail,
        userId = userId.toInt(),
        userName = userName
    )
}