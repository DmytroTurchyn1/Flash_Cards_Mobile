package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Settings_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_ukr)
    }

    fun english(view: android.view.View) {
        val English_vercion = Intent(this, Home_en::class.java)
        startActivity(English_vercion);
    }
}