package com.example.flashcards.notreworked

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.feature.addword.AddWordActivity
import com.example.flashcards.feature.menu.MenuActivity

class My_words_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words_ukr)
    }

    fun menu(view: android.view.View) {
        val menu = Intent(this, MenuActivity::class.java)
        startActivity(menu);
    }

    fun learnWords(view: android.view.View) {
        val menu = Intent(this, Learn_Words_ukr::class.java)
        startActivity(menu);
    }
    fun addWord(view: android.view.View) {
        val menu = Intent(this, AddWordActivity::class.java)
        startActivity(menu);
    }
}