package com.example.homeworkandroid.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homeworkandroid.domain.ItemsInteractor

class MyViewModelFactory(private  val interactor: ItemsInteractor):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(interactor) as T
    }


}