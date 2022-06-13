package com.example.courseinterapp.domain

import com.example.courseinterapp.domain.repository.ApiRepository
import com.example.courseinterapp.domain.repository.impl.ApiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository
}