package com.example.homeworkandroid.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkandroid.R
import com.example.homeworkandroid.databinding.FragmentLoginBinding
import com.example.homeworkandroid.presentation.view.home.HomeFragment
import com.example.homeworkandroid.utils.NavigationExt.fmReplace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginPresenter.setView(this)

        viewBinding.btnShowCreds.setOnClickListener {

            if (viewBinding.etLogin.text.toString().isEmpty() || viewBinding.etLogin.length() > 8) {
                viewBinding.etLogin.error = getString(R.string.login_error)

            } else if (viewBinding.etPassword.text.toString()
                    .isEmpty() || viewBinding.etPassword.length() > 8
            ) {
                viewBinding.etPassword.error = getString(R.string.password_entry_error)
            } else {

                loginPresenter.loginUser(
                    viewBinding.etLogin.text.toString(),
                    viewBinding.etPassword.text.toString()
                )
            }
        }

    }

    override fun userLoggedIn() {
        fmReplace(parentFragmentManager, HomeFragment(), false)

    }

}




