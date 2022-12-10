package com.example.homeworkandroid.presentation.view

import com.example.homeworkandroid.model.ItemsModel

interface ItemsView {

    fun dataReceive(list: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    )


}