package com.example.homeworkandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homeworkandroid.databinding.FragmentDetailsBinding
import com.example.homeworkandroid.presentation.view.auth.LoginFragment
import com.example.homeworkandroid.utils.BundleConstants
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsViewModel by viewModels()


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
            viewBinding.detailsDescription.setBackgroundResource(image)

        }


        viewBinding.btnFinish.setOnClickListener {
            viewModel.logoutUser()

        }

        viewModel.nav.observe(viewLifecycleOwner) {
            NavigationExt.fmReplace(parentFragmentManager, LoginFragment(), false)
        }

    }

}

