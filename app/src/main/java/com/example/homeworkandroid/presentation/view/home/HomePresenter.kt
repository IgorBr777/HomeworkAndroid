package com.example.homeworkandroid.presentation.view.home

import com.example.homeworkandroid.domain.auth.AuthInteractor
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {
    private lateinit var homeView: HomeView
    fun setView(homeFragment: HomeFragment) {

        homeView = homeFragment

    }


    fun showUserData() {

        val showUserCreds = authInteractor.getUserCreds()
        homeView.userShowData(showUserCreds)

    }
}