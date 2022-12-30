package com.example.homeworkandroid.presentation.view.home

import com.example.homeworkandroid.R
import com.example.homeworkandroid.domain.items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(

    private val itemsInteractor: ItemsInteractor
) {
    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment) {
        itemsView = itemsFragment
    }

    fun getItems() {
        val listItems = itemsInteractor.getData()
        itemsView.itemsReceived(listItems)
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
        itemsView.itemClicked(title, time, description, imageView, imageView2)

    }


}


