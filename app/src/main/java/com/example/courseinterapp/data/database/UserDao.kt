package com.example.courseinterapp.data.database

import androidx.room.*
import com.example.courseinterapp.data.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM userentity")
    suspend fun getUsers(): List<UserEntity>

    @Query("SELECT * FROM userentity WHERE userId IN (:userId)")
    suspend fun getUser(userId: Int): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}