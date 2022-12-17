package com.example.homeworkandroid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.R
import com.example.homeworkandroid.databinding.FragmentOnBoardingBinding
import com.example.homeworkandroid.utils.LoginConstant.login
import com.example.homeworkandroid.utils.LoginConstant.password
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog = AlertDialog.Builder(view.context)

        viewBinding.btnEnter.setOnClickListener {

            if (viewBinding.etText.text.toString() == login && viewBinding.etText2.text.toString() == password) {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.welcome_back))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment())
                    .commit()
                dialog.show()

            } else {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.try_again_enter_login_password))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, OnBoardingFragment())
                    .commit()
                dialog.show()

            }

        }

    }
}









