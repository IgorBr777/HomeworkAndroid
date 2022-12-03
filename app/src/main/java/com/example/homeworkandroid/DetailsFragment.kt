package com.example.homeworkandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView



class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsTitle =view.findViewById<TextView>(R.id.details_title)
        val detailsTime =view.findViewById<TextView>(R.id.details_time)
        val detailsDescription =view.findViewById<TextView>(R.id.details_description)
        val detailsImage =view.findViewById<ImageView>(R.id.details_image_car)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val title =safeBundle.getString(Constance.TITLE)
            val time = safeBundle.getString(Constance.TIME)
            val description = safeBundle.getString(Constance.DESCRIPTION)
            val image = safeBundle.getInt(Constance.IMAGE_VIEW)

            detailsTitle.text =title
            detailsTime.text =time
            detailsDescription.text =description
            detailsImage.setBackgroundResource(image)

        }
    }
    }
