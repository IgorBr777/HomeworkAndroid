package com.example.homeworkandroid.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkandroid.R
import com.example.homeworkandroid.domain.ItemsInteractor
import com.example.homeworkandroid.model.ItemsModel

class ItemsViewModel(private val itemsInteractor: ItemsInteractor) : ViewModel() {
    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }

    fun imageViewClicked() {

        _msg.value = R.string.imageView_clicked

    }

    fun elementClicked(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int
    ) {
        _bundle.value = NavigateWithBundle(title, time, description, imageView, imageView2)

    }

}

data class NavigateWithBundle(

    val title: String,
    val time: String,
    val description: String,
    val image: Int,
    val image2: Int

)