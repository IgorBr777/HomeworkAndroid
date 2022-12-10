package com.example.homeworkandroid.domain

import com.example.homeworkandroid.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel> {

        return itemsRepository.getData()

    }


}