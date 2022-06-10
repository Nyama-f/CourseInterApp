package com.example.courseinterapp.domain

import com.example.courseinterapp.domain.useCases.GetUsersUseCase
import com.example.courseinterapp.domain.useCases.impl.GetUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindsGetUsersUseCase(getUsersUseCaseImpl: GetUsersUseCaseImpl): GetUsersUseCase

}