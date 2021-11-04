package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Add_word_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word_en)
    }
    fun menu(view: android.view.View) {
        val menu = Intent(this, Menu_en::class.java)
        startActivity(menu);
    }
}