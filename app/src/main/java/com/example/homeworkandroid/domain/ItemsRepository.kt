package com.example.homeworkandroid.domain

import com.example.homeworkandroid.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>

}