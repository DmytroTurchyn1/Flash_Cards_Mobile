package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class new_words_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_words_en)
    }
    fun menu(view: android.view.View) {
        val menu = Intent(this, Menu_ukr::class.java)
        startActivity(menu);
    }
}