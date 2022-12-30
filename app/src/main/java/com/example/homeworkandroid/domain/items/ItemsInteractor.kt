package com.example.homeworkandroid.domain.items

import com.example.homeworkandroid.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel> {

        return itemsRepository.getData()

    }

}