package com.example.homeworkandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.homeworkandroid.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

  }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.first_item -> startMainActivity2(this, "" )
            R.id.second_item -> startMainActivity2(this, "" )
            R.id.third_item -> onBackPressed()
            R.id.four_item -> finishAffinity()

        }
        return super.onOptionsItemSelected(item)
    }
}