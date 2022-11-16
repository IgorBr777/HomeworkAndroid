package com.example.homeworkandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val  data:String = intent.getStringExtra(KEY)?:getString(R.string.no_data)
        textView2.text=data

        val textView3 = findViewById<TextView>(R.id.textView3)

        val  data2:String = intent.getStringExtra(KEY2)?:getString(R.string.no_data)
        textView3.text=data2
        val  data3 = intent.getStringExtra(KEY3)
        supportActionBar?.title = data3
    }

    companion object {
        private const val KEY = "1"
        private const val KEY2 = "2"
        private const val KEY3 = "3"
        fun startMainActivity2(context: Context, string: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, context.getString(R.string.welcome_main_activity_2))
            intent.putExtra(KEY2, context.getString(R.string.hello_teach_me_skills))
            intent.putExtra(KEY3, context.getString(R.string.clicked_second_item))
            context.startActivity(intent)

        }

    }

}