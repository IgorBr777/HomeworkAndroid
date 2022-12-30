package com.example.homeworkandroid.di

import com.example.homeworkandroid.domain.auth.AuthInteractor
import com.example.homeworkandroid.domain.items.ItemsInteractor
import com.example.homeworkandroid.presentation.view.MainPresenter
import com.example.homeworkandroid.presentation.view.auth.LoginPresenter
import com.example.homeworkandroid.presentation.view.auth.OnBoardingPresenter
import com.example.homeworkandroid.presentation.view.home.DetailsPresenter
import com.example.homeworkandroid.presentation.view.home.HomePresenter
import com.example.homeworkandroid.presentation.view.home.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class PresentationModule {

    @Provides

    fun provideMainPresenter(authInteractor: AuthInteractor
    ): MainPresenter {
        return MainPresenter(authInteractor)

    }


    @Provides

    fun provideHomePresenter(
        authInteractor: AuthInteractor
    ): HomePresenter {
        return HomePresenter(authInteractor)

    }

    @Provides

    fun provideLoginPresenter(
        authInteractor: AuthInteractor
    ): LoginPresenter {
        return LoginPresenter(authInteractor)

    }
    @Provides

    fun provideDetailsPresenter(
        authInteractor: AuthInteractor
    ): DetailsPresenter {
        return DetailsPresenter(authInteractor)

    }

    @Provides

    fun provideItemsPresenter(

        itemsInteractor: ItemsInteractor
    )

        : ItemsPresenter {
        return ItemsPresenter(itemsInteractor)

    }

    @Provides

    fun provideOnBoardingPresenter(

    ) : OnBoardingPresenter {
        return OnBoardingPresenter()

    }







}