package com.example.homeworkandroid.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homeworkandroid.R
import com.example.homeworkandroid.databinding.FragmentLoginBinding
import com.example.homeworkandroid.presentation.view.home.HomeFragment
import com.example.homeworkandroid.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewBinding.btnShowCreds.setOnClickListener {

            if (viewBinding.etLogin.text.toString().isEmpty() || viewBinding.etLogin.length() > 8) {
                viewBinding.etLogin.error = getString(R.string.login_error)

            } else if (viewBinding.etPassword.text.toString()
                    .isEmpty() || viewBinding.etPassword.length() > 8
            ) {
                viewBinding.etPassword.error = getString(R.string.password_entry_error)
            } else {

                viewModel.loginUser(
                    viewBinding.etLogin.text.toString(),
                    viewBinding.etPassword.text.toString()
                )
            }

            viewModel.nav.observe(viewLifecycleOwner) {
                fmReplace(parentFragmentManager, HomeFragment(), false)

            }
        }

    }

}




