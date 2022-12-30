package com.example.homeworkandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.databinding.FragmentDetailsBinding
import com.example.homeworkandroid.presentation.view.auth.LoginFragment
import com.example.homeworkandroid.utils.BundleConstants
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(BundleConstants.TITLE),
                safeBundle.getString(BundleConstants.TIME),
                safeBundle.getString(BundleConstants.DESCRIPTION),
                safeBundle.getInt(BundleConstants.IMAGE_VIEW)
            )

        }


        viewBinding.btnFinish.setOnClickListener {
            detailsPresenter.logoutUser()

        }

    }

    override fun userLoggedOut() {
        NavigationExt.fmReplace(parentFragmentManager, LoginFragment(), false)

    }

    override fun displayItemData(title: String, time: String, description: String, imageView: Int) {
        viewBinding.detailsTitle.text = title
        viewBinding.detailsTime.text = time
        viewBinding.detailsDescription.text = description
        viewBinding.detailsDescription.setBackgroundResource(imageView)
    }
}
