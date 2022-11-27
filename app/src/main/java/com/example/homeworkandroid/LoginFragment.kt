package com.example.homeworkandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

const val login = "Igor"
const val password = "2206"

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newRegistration = view.findViewById<Button>(R.id.btnNewReg)
        val btnSingUp = view.findViewById<Button>(R.id.btnSingUp)
        val editText = view.findViewById<EditText>(R.id.et_text)
        val editText2 = view.findViewById<EditText>(R.id.et_text2)
        val dialog = AlertDialog.Builder(view.context)

        btnSingUp.setOnClickListener {

            if (editText.text.toString() == login && editText2.text.toString() == password) {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.welcome_back))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
                dialog.show()

            } else {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.you_need_to_register))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, RegistrationFragment())
                    .commit()
                dialog.show()

            }

        }

        newRegistration.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, RegistrationFragment())
                .commit()

        }

    }
}

