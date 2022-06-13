package com.example.courseinterapp.domain

import android.content.Context
import androidx.room.Room
import com.example.courseinterapp.data.database.Database
import com.example.courseinterapp.data.database.UserDao
import com.example.courseinterapp.domain.repositories.DatabaseRepository
import com.example.courseinterapp.domain.repositories.impl.DatabaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Binds
    abstract fun bindsDatabaseRepository(databaseRepositoryImpl: DatabaseRepositoryImpl): DatabaseRepository

    companion object {
        @Provides
        fun provideUserDao(database: Database): UserDao = database.userDao()

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext appContext: Context): Database =
            Room.databaseBuilder(
                appContext,
                Database::class.java,
                "users"
            ).build()
    }
}