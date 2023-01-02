package com.example.homeworkandroid.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homeworkandroid.databinding.FragmentOnBoardingBinding
import com.example.homeworkandroid.presentation.view.home.ItemsFragment
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: OnBoardingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewBinding.btnItemsFragment.setOnClickListener {
            viewModel.goToItemsFragment()

        }
        viewModel.btnClicked.observe(viewLifecycleOwner) {
            NavigationExt.fmReplace(parentFragmentManager, ItemsFragment(), false)
        }
    }

}



