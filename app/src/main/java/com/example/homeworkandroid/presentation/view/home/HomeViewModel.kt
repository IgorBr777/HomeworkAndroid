package com.example.homeworkandroid.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkandroid.domain.auth.AuthInteractor
import com.example.homeworkandroid.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor

) : ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds


    fun showUserDate() {

        _userCreds.value = authInteractor.getUserCreds()

    }


}