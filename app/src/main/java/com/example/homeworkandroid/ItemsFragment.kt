package com.example.homeworkandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid.adapter.ItemsAdapter
import com.example.homeworkandroid.listener.ItemsListener
import com.example.homeworkandroid.model.ItemsModel
import java.time.LocalDate

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

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
        itemsAdapter.submitList(listItems.toList())

    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_LONG).show()

    }
    override fun onElementSelected(title:String, time:String,description:String, imageView: Int,imageView2: Int,) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("time", time)
        bundle.putString("description", description)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .add(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}