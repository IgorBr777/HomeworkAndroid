package com.example.homeworkandroid.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.databinding.FragmentHomeBinding
import com.example.homeworkandroid.model.UserModel
import com.example.homeworkandroid.presentation.view.auth.OnBoardingFragment
import com.example.homeworkandroid.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!


    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentHomeBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)
        homePresenter.showUserData()

        viewBinding.btnGoToOnBoarding.setOnClickListener {
            NavigationExt.fmReplace(parentFragmentManager, OnBoardingFragment(), false)


        }


    }

    override fun userShowData(userCreds: UserModel) {
        viewBinding.tvUserCreds.text =
            "${userCreds.userName.toString()} ${userCreds.userPassword.toString()}"

    }


}
