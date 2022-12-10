package com.example.homeworkandroid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.databinding.FragmentDetailsBinding
import com.example.homeworkandroid.utils.BundleConstants


class DetailsFragment : Fragment() {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safeBundle ->
            val title = safeBundle.getString(BundleConstants.TITLE)
            val time = safeBundle.getString(BundleConstants.TIME)
            val description = safeBundle.getString(BundleConstants.DESCRIPTION)
            val image = safeBundle.getInt(BundleConstants.IMAGE_VIEW)

            viewBinding.detailsTitle.text = title
            viewBinding.detailsTime.text = time
            viewBinding.detailsDescription.text = description
            viewBinding.detailsImageCar.setBackgroundResource(image)

        }
    }
}
