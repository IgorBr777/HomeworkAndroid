package com.example.homeworkandroid.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkandroid.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

) : ViewModel() {


    private val _btnClicked = MutableLiveData<Unit?>()
    val btnClicked: LiveData<Unit?> = _btnClicked


    fun goToItemsFragment() {

        authInteractor.goToItemsFragment()
        _btnClicked.value = Unit

    }


}