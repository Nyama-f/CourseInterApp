package com.example.courseinterapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey
    val userId: Int,

    @ColumnInfo(name = "avatar")
    val userImage: String,

    @ColumnInfo(name = "email")
    val userEmail: String,

    @ColumnInfo(name = "name")
    val userName: String,

) {

    fun toUser() = User(
        userEmail = userEmail,
        userImage = userImage,
        userId = userId.toString(),
        userName = userName,
    )
}