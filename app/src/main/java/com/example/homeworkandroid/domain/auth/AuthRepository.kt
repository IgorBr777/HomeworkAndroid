package com.example.homeworkandroid.domain.auth

import com.example.homeworkandroid.model.UserModel

interface AuthRepository {

fun loginUser(userName: String, userPassword:String)

fun showUserCreds():UserModel

fun doesUserExists():Boolean

fun userLogout()

fun goToItemsFragment()

}