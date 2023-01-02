package com.example.homeworkandroid.data.auth

import com.example.homeworkandroid.domain.auth.AuthRepository
import com.example.homeworkandroid.data.shareprefs.SharedPreferenceHelper
import com.example.homeworkandroid.model.UserModel
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferenceHelper: SharedPreferenceHelper


) : AuthRepository {

    override fun loginUser(userName: String, userPassword: String) {

        sharedPreferenceHelper.saveUserName(userName)
        sharedPreferenceHelper.saveUserPassword(userPassword)


    }

    override fun userLogout() {
        sharedPreferenceHelper.removeUser()
    }

    override fun goToItemsFragment() {

    }

    override fun showUserCreds(): UserModel {
        return  sharedPreferenceHelper.getUserCreds()
    }

    override fun doesUserExists(): Boolean {
        return  sharedPreferenceHelper.checkUserExists()
    }


}