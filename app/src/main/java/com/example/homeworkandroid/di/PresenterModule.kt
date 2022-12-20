package com.example.homeworkandroid.di

import com.example.homeworkandroid.domain.ItemsInteractor
import com.example.homeworkandroid.presentation.view.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class PresenterModule {

    @Provides

    fun provideItemsPresenter(

        itemsInteractor: ItemsInteractor)

        : ItemsPresenter {
        return ItemsPresenter(itemsInteractor)

    }








}