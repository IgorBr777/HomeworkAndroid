package com.example.homeworkandroid.presentation.view

import com.example.homeworkandroid.R
import com.example.homeworkandroid.domain.ItemsInteractor

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
) {


    fun getData() {
        val listItems = itemsInteractor.getData()
        itemsView.dataReceive(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.imageView_clicked)
    }

    fun elementSelected(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int,
    ) {
        itemsView.goToDetails(title, time, description, imageView, imageView2)

    }

}