package com.example.homeworkandroid.presentation.adapter.listener

interface ItemsListener {

    fun onClick()

    fun onElementSelected(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    )


}