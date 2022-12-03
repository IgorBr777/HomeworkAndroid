package com.example.homeworkandroid

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkandroid.model.ItemsModel
import java.time.LocalDate

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle


    fun getData() {

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                "BMW",
                "BMW " +
                        "is a German automobile company specializing in the production of passenger " +
                        "and sports cars, cross-country vehicles and motorcycles. The headquarters is located in Munich.",
                "${LocalDate.now()}  ", R.drawable.bmv, R.drawable.asterisk
            ),
            ItemsModel(
                "AUDI",
                "Audi  a German company specializing " +
                        "in the production of passenger cars. " +
                        "It is part of the Volkswagen Group. The headquarters is located in Ingoldstadt.",
                "${LocalDate.now()}  ", R.drawable.audi, R.drawable.asterisk
            ),

            ItemsModel(
                "Ferrari",
                "Ferrari, an Italian company specializing " +
                        "in the production of racing and luxury cars. Since 1989, " +
                        "it has been a subsidiary of the FIAT Concern. The headquarters is located in Maranello.",
                "${LocalDate.now()}  ", R.drawable.ferrari, R.drawable.asterisk
            ),

            ItemsModel(
                "Aston Martin",
                "Aston Martin is a legendary English company specializing in the production of ultra-expensive sports supercars. " +
                        "It is a division of the Ford Motor Company concern. The headquarters is located in Newport Pagnell.",
                "${LocalDate.now()}  ", R.drawable.aston_martin, R.drawable.asterisk
            ),
            ItemsModel(
                "Lamborghini",
                "Lamborghini is owned by Audi, which in turn is a division of Volkswagen AG. " +
                        "Produces supercar capable of speeds up to 350 kilometers per hour.",
                "${LocalDate.now()}  ", R.drawable.lamborghini, R.drawable.asterisk
            ),
            ItemsModel(
                "Lexus",
                "Lexus is a Japanese automobile company specializing in the production of passenger cars. " +
                        "Is a division of Toyota Motors Corporation Headquartered in Toyota.",
                "${LocalDate.now()}  ", R.drawable.lexus, R.drawable.asterisk
            ),
            ItemsModel(
                "Maserati",
                "Maserati  an Italian company specializing in the production of comfortable sports cars with an efficient appearance and high dynamic performance. " +
                        "It is part of the largest Italian automobile corporation \"FIAT\".",
                "${LocalDate.now()}  ", R.drawable.maserati, R.drawable.asterisk
            ),
            ItemsModel(
                "Porsche",
                "PORSCHE a German automobile company. The headquarters is located in Stuttgart.",
                "${LocalDate.now()} ", R.drawable.porshe, R.drawable.asterisk
            ),
        )

        _items.value = listItems

    }

    fun imageViewClicked() {

        _msg.value = "ImageView clicked"


    }

    fun elementClicked(
        title: String,
        time: String,
        description: String,
        imageView: Int,
        imageView2: Int
    ) {
        _bundle.value = NavigateWithBundle(title, time, description, imageView,imageView2)

    }

}

data class NavigateWithBundle(

    val title: String,
    val time: String,
    val description: String,
    val image: Int,
    val image2: Int


)