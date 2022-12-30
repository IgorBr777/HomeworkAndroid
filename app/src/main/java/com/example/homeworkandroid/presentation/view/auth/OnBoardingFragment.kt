package com.example.homeworkandroid.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.databinding.FragmentOnBoardingBinding
import com.example.homeworkandroid.presentation.view.home.ItemsFragment
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoardingPresenter.setView(this)

        viewBinding.btnItemsFragment.setOnClickListener {
            onBoardingPresenter.goToItemsFragment()


        }

    }


    override fun goToItemsFragment() {
        NavigationExt.fmReplace(parentFragmentManager, ItemsFragment(), false)


    }

}



