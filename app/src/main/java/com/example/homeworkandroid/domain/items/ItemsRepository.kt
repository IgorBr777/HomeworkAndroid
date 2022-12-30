package com.example.homeworkandroid.domain.items

import com.example.homeworkandroid.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>

}