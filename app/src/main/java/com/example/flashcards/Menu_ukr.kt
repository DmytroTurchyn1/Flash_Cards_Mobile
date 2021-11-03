package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Menu_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_ukr)
    }

    fun home_ukr(view: android.view.View) {
        val home_ukr = Intent(this, MainActivity::class.java)
        startActivity(home_ukr);
    }
    fun settings(view: android.view.View) {
        val settings = Intent(this, Settings_ukr::class.java)
        startActivity(settings);
    }
    fun about_program(view: android.view.View) {
        val about_program = Intent(this, About_me_ukr::class.java)
        startActivity(about_program);
    }
    fun irregular_words(view: android.view.View) {
        val irregular_words = Intent(this, Irregular_words_ukr::class.java)
        startActivity(irregular_words);
    }
    fun new_words_ukr(view: android.view.View) {
        val new_words_ukr = Intent(this, new_words_ukr::class.java)
        startActivity(new_words_ukr);
    }
    fun my_words(view: android.view.View) {
        val my_words = Intent(this, My_words_ukr::class.java)
        startActivity(my_words);
    }
}