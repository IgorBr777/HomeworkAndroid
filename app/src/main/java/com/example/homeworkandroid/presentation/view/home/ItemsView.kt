package com.example.homeworkandroid.presentation.view.home

import com.example.homeworkandroid.model.ItemsModel

interface ItemsView {

    fun itemsReceived(list: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun itemClicked(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int
    )


}