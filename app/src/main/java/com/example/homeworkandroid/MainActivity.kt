package com.example.homeworkandroid

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(getString(R.string.color_coral))))


        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)
        val btnDisplay1 = findViewById<Button>(R.id.btnDisplay1)
        val textView = findViewById<TextView>(R.id.tv_text)
        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout1)
        val layout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)
        val name = "Name: "
        val password = "Password: "

        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setMessage("You must enter your name and password for registration")
            .setPositiveButton("OK") { dialog, _ ->
                Toast.makeText(this, "name and password saved", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
        btnDisplay1.setOnClickListener {
            dialog.show()

            if (editText.text.toString().isEmpty()) {
                dialog.setMessage("You must enter your name and password for registration")
                layout1.setErrorIconDrawable(R.drawable.ic_baseline_error_24)
                editText.error = "name can't be empty"
            }
            else {
                dialog.setMessage("${name}${editText.text.toString()}  ${password}${editText2.text.toString()}")
            }
            if (editText2.text.toString().isEmpty()) {
                dialog.setMessage("You must enter your name and password for registration")
                layout2.setErrorIconDrawable(R.drawable.ic_baseline_error_24)
                editText2.error = "password can't be empty"
            } else {dialog.setMessage("${name}${editText.text.toString()} ${password}${editText2.text.toString()} ")
                textView.text ="${editText.text.toString().isEmpty()} ${editText2.text.toString()}"
            }
        }
        }

    }




