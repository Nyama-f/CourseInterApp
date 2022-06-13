package com.example.courseinterapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.courseinterapp.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun userDao(): UserDao
}