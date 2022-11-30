package com.example.homeworkandroid.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkandroid.listener.ItemsListener
import com.example.homeworkandroid.R
import com.example.homeworkandroid.model.ItemsModel

class ItemsViewHolder(private val view: View,
                      private val itemsListener: ItemsListener
                      ): RecyclerView.ViewHolder(view) {


        fun bind(itemsModel: ItemsModel){
            val title = view.findViewById<TextView>(R.id.tv_title)
            val description = view.findViewById<TextView>(R.id.tv_description)
            val time  = view.findViewById<TextView>(R.id.tv_time)
            val imageView = view.findViewById<ImageView>(R.id.iv_image_car)
            val imageView2 = view.findViewById<ImageView>(R.id.iv_image_asterisk)

            title.text = itemsModel.title
            description.text = itemsModel.description
            time.text = itemsModel.time
            imageView.setBackgroundResource(itemsModel.image)
            imageView2.setBackgroundResource(itemsModel.image2)

            imageView.setOnClickListener {
                itemsListener.onClick()
            }

            itemView.setOnClickListener{

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