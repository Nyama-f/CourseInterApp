package com.example.courseinterapp.data.model

import com.google.gson.annotations.SerializedName

data class UserApi(
    @SerializedName("avatar")
    val userImage: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("id")
    val userId: String,
    @SerializedName("name")
    val userName: String
) {
    fun toUser() = User(
        userImage,
        userEmail,
        userId,
        userName,
    )
}