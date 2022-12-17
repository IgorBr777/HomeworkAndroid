package com.example.homeworkandroid.di

import com.example.homeworkandroid.data.ItemsRepositoryImpl
import com.example.homeworkandroid.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class DataModule {

@Binds
abstract  fun bindItemsRepository(
    itemsRepositoryImpl: ItemsRepositoryImpl

):ItemsRepository

}