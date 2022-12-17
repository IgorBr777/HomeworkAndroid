package com.example.homeworkandroid.di

import com.example.homeworkandroid.domain.ItemsInteractor
import com.example.homeworkandroid.domain.ItemsRepository
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
    ):ItemsInteractor{
return ItemsInteractor(itemsRepository)

    }

}