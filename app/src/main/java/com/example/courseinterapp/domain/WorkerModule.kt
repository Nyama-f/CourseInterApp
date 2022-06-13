package com.example.courseinterapp.domain

import com.example.courseinterapp.domain.useCases.AddUserUseCase
import com.example.courseinterapp.domain.useCases.impl.AddUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class WorkerModule {

    @Binds
    abstract fun bindsAddUserUseCase(addUserUseCaseImpl: AddUserUseCaseImpl): AddUserUseCase

}