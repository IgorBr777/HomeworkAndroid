package com.example.homeworkandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnRegistration = view.findViewById<Button>(R.id.btnRegistration)
        val editText3 = view.findViewById<EditText>(R.id.et_text3)
        val editText4 = view.findViewById<EditText>(R.id.et_text4)
        val dialog = AlertDialog.Builder(view.context)

        btnRegistration.setOnClickListener {

            if (editText3.text.toString().isEmpty() && editText4.text.toString().isEmpty()) {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.try_registering_again))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, RegistrationFragment())
                    .commit()
                dialog.show()

            } else {
                dialog.setTitle(getString(R.string.information))
                dialog.setMessage(getString(R.string.successful_registration))
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
                dialog.show()

            }

        }

    }

}
