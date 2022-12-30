package com.example.homeworkandroid.presentation.view

import com.example.homeworkandroid.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity

    }


    fun checkUserExists() {
        val doesUserExists = authInteractor.checkUserExists()
        mainView.userExistsResult(doesUserExists)


    }
}