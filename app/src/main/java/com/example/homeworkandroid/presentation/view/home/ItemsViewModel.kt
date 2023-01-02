package com.example.homeworkandroid.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkandroid.R
import com.example.homeworkandroid.domain.items.ItemsInteractor
import com.example.homeworkandroid.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private  val itemsInteractor: ItemsInteractor

):ViewModel()

{
    private  val _items =MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> =_items

    private  val _msg =MutableLiveData<Int>()
    val msg: LiveData<Int> =_msg

    private  val _bundle =MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> =_bundle


    fun getData(){

        val listItems =itemsInteractor.getData()
        _items.value=listItems

    }

    fun imageViewClick(){

        _msg.value =R.string.imageView_clicked

    }

    fun elementClicked( title: String,
                        time: String,
                        description: String,
                        imageView: Int,
                        imageView2: Int)
    {
        _bundle.value=NavigateWithBundle(title,description,time,imageView,imageView2)

    }

    fun userNavigated(){
        _bundle.value =null
    }

}

data class NavigateWithBundle(
    val title: String,
    val description: String,
    val time: String,
    val image: Int,
    val image2: Int

)