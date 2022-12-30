package com.example.homeworkandroid.presentation.view.home

interface DetailsView {

    fun userLoggedOut()

    fun displayItemData(title: String,
                        time: String,
                        description: String,
                        imageView: Int)

}