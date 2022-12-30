package com.example.homeworkandroid.domain.auth

import com.example.homeworkandroid.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private  val authRepository: AuthRepository) {

fun loginUser(userName: String, userPassword:String){
    authRepository.loginUser(userName,userPassword)

}

fun getUserCreds(): UserModel {
    return  authRepository.showUserCreds()

}

    fun checkUserExists():Boolean{
        return authRepository.doesUserExists()


    }


    fun logoutUser(){

        authRepository.userLogout()
    }



}