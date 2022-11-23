package com.example.homeworkandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegistration1 = findViewById<Button>(R.id.btnRegistration1)
        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)
        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)
        val login = getString(R.string.login)
        val password = getString(R.string.password)
        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)

        val computer = ComputerBuilder.Builder
            .setOS(true)
            .setMouse(true)
            .setKeyboard(true)
            .setMonitor(true)
            .setRAM(16)
            .setSSD(512)
            .build()

        rb1.setOnClickListener {

            if (rb1.isChecked) {

                rb2.isChecked = false

            } else {

                rb1.isChecked = true

            }
            Toast.makeText(
                this, "${computer.hasOS()} " +
                        "${computer.hasMouse()}" +
                        "${computer.hasKeyboard()}" +
                        "${computer.hasMonitor()}" +
                        "${computer.howMuchRAM()}" +
                        "${computer.howMuchSSD()}", Toast.LENGTH_LONG
            ).show()
        }
        rb2.setOnClickListener {

            if (rb2.isChecked) {

                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }
        }

        val dialog = AlertDialog.Builder(this)

            .setTitle(getString(R.string.information1))
            .setMessage(getString(R.string.you_must_enter_login_password))
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->

            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }

        btnRegistration1.setOnClickListener {

            dialog.show()

            if (editText.text.toString().isEmpty()) {
                dialog.setMessage(getString(R.string.you_must_enter_login_password))
                layout1.setErrorIconDrawable(R.drawable.ic_baseline_error_24)
                editText.error = getString(R.string.login_not_empty)
            } else {
                dialog.setMessage("${login}${editText.text.toString()}  ${password}${editText2.text.toString()}")
            }
            if (editText2.text.toString().isEmpty()) {
                dialog.setMessage(getString(R.string.you_must_enter_login_password))
                layout2.setErrorIconDrawable(R.drawable.ic_baseline_error_24)
                editText2.error = getString(R.string.password_not_empty)
            } else {
                dialog.setMessage("${login}${editText.text.toString()} ${password}${editText2.text.toString()} ")

            }
        }
    }

}


