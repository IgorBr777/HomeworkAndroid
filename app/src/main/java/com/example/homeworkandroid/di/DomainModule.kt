package com.example.homeworkandroid.di

import com.example.homeworkandroid.domain.auth.AuthInteractor
import com.example.homeworkandroid.domain.auth.AuthRepository
import com.example.homeworkandroid.domain.items.ItemsInteractor
import com.example.homeworkandroid.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class DomainModule {
@Provides
    fun provideItemsInteractor(
        itemsRepository: ItemsRepository
    ): ItemsInteractor {
return ItemsInteractor(itemsRepository)

    }

    @Provides
    fun provideAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {
        return AuthInteractor(authRepository)

    }

}