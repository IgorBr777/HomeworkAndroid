package com.example.homeworkandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homeworkandroid.databinding.FragmentHomeBinding
import com.example.homeworkandroid.presentation.view.auth.OnBoardingFragment
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentHomeBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showUserDate()

        viewBinding.btnGoToOnBoarding.setOnClickListener {
            NavigationExt.fmReplace(parentFragmentManager, OnBoardingFragment(), false)


        }

        viewModel.userCreds.observe(viewLifecycleOwner) {
            viewBinding.tvUserCreds.text = "${it.userName} \n ${it.userPassword}"

        }

    }


}
