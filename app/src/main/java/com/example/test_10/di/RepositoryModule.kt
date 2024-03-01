package com.example.test_10.di

import com.example.test_10.data.repository.ApiRepositoryImpl
import com.example.test_10.data.service.ApiService
import com.example.test_10.domain.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideApiRepository(
        apiService: ApiService
    ): ApiRepository {
        return ApiRepositoryImpl(
            apiService = apiService
        )
    }
}