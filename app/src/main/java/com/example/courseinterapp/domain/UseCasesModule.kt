package com.example.courseinterapp.domain

import com.example.courseinterapp.domain.useCases.*
import com.example.courseinterapp.domain.useCases.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindsGetUsersUseCase(getUsersUseCaseImpl: GetUsersUseCaseImpl): GetUsersUseCase

    @Binds
    abstract fun bindsAddUsersUseCase(addUsersUseCaseImpl: AddUserUseCaseImpl): AddUserUseCase

    // Database

    @Binds
    abstract fun bindsGetUserDatabaseUseCase(getUserDatabaseUseCaseImpl: GetUserDatabaseUseCaseImpl): GetUserDatabaseUseCase

    @Binds
    abstract fun bindsGetUsersDatabaseUseCase(getUsersDatabaseUseCaseImpl: GetUsersDatabaseUseCaseImpl): GetUsersDatabaseUseCase

    @Binds
    abstract fun bindsInsertUserDatabaseUseCase(insertUserDatabaseUseCaseImpl: InsertUserDatabaseUseCaseImpl): InsertUserDatabaseUseCase

    @Binds
    abstract fun bindsInsertUsersUseCase(insertUsersDatabaseUseCaseImpl: InsertUsersDatabaseUseCaseImpl): InsertUsersDatabaseUseCase

    @Binds
    abstract fun bindsDeleteuserDatabseUseCase(deleteUserDatabaseUseCaseImpl: DeleteUserDatabaseUseCaseImpl): DeleteUserDatabaseUseCase
}