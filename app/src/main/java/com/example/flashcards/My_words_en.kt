package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class My_words_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words_en)
    }
    fun menu_btn(view: android.view.View) {
        val menu = Intent(this, Menu_en::class.java)
        startActivity(menu);
    }
    fun learnWords(view: android.view.View) {
        val menu = Intent(this, Learn_Words_en::class.java)
        startActivity(menu);
    }
    fun addWord(view: android.view.View) {
        val menu = Intent(this, Add_word_en::class.java)
        startActivity(menu);
    }
}