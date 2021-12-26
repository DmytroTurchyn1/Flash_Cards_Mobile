package com.example.flashcards.trash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.feature.menu.MenuActivity

class Settings_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_ukr)
    }

    fun english(view: android.view.View) {
        val English_vercion = Intent(this, Home_en::class.java)
        startActivity(English_vercion);
    }
    fun menu_btn(view: android.view.View) {
        val menu = Intent(this, MenuActivity::class.java)
        startActivity(menu);
    }
}