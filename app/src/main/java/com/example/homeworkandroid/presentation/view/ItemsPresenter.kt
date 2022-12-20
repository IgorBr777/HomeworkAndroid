package com.example.homeworkandroid.presentation.view

import com.example.homeworkandroid.R
import com.example.homeworkandroid.domain.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(

    private val itemsInteractor: ItemsInteractor)
{
    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }

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


