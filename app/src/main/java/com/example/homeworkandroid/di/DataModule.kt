package com.example.homeworkandroid.di

import android.content.Context
import com.example.homeworkandroid.data.auth.AuthRepositoryImpl
import com.example.homeworkandroid.data.items.ItemsRepositoryImpl
import com.example.homeworkandroid.domain.auth.AuthRepository
import com.example.homeworkandroid.domain.items.ItemsRepository
import com.example.homeworkandroid.data.shareprefs.SharedPreferenceHelper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class DataModule {

@Binds
abstract  fun bindItemsRepository(
    itemsRepositoryImpl: ItemsRepositoryImpl

): ItemsRepository

    @Binds
    abstract  fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val  SP_KEY ="SP_KEY"

        @Provides

        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferenceHelper {

            return  SharedPreferenceHelper(context.getSharedPreferences(SP_KEY,
                Context.MODE_PRIVATE
            ))

        }

    }

}