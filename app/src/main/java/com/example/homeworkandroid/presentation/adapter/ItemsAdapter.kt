package com.example.homeworkandroid.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid.databinding.ItemCarBinding
import com.example.homeworkandroid.model.ItemsModel
import com.example.homeworkandroid.presentation.adapter.listener.ItemsListener

class ItemsAdapter(private val itemsListener: ItemsListener) :
    RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()
    fun submitList(list: List<ItemsModel>) {
        this.listItems = list.toMutableList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])

    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}