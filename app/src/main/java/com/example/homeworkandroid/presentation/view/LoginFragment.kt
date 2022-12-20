package com.example.homeworkandroid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.R
import com.example.homeworkandroid.databinding.FragmentLoginBinding
import com.example.homeworkandroid.utils.LoginConstant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog = AlertDialog.Builder(view.context)

        viewBinding.btnEnter.setOnClickListener {

            if (viewBinding.etText.text.toString() == LoginConstant.login && viewBinding.etText2.text.toString() == LoginConstant.password) {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.welcome_back))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, OnBoardingFragment())
                    .commit()
                dialog.show()

            } else {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.try_again_enter_login_password))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, LoginFragment())
                    .commit()
                dialog.show()

            }

        }

    }

}
