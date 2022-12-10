package com.example.homeworkandroid.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid.databinding.ItemCarBinding
import com.example.homeworkandroid.model.ItemsModel
import com.example.homeworkandroid.presentation.adapter.listener.ItemsListener

class ItemsViewHolder(
    private val viewBinding: ItemCarBinding,
    private val itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(itemsModel: ItemsModel) {

        viewBinding.tvTitle.text = itemsModel.title
        viewBinding.tvDescription.text = itemsModel.description
        viewBinding.tvTime.text = itemsModel.time
        viewBinding.ivImageCar.setBackgroundResource(itemsModel.image)
        viewBinding.ivImageAsterisk.setBackgroundResource(itemsModel.image2)

        viewBinding.ivImageCar.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {

            itemsListener.onElementSelected(
                itemsModel.title,
                itemsModel.description,
                itemsModel.time,
                itemsModel.image,
                itemsModel.image2
            )

        }

    }

}