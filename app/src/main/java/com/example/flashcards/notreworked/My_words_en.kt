package com.example.flashcards.notreworked

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.feature.learnwords.LearnWordsActivity

class My_words_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words_en)
    }
    fun menu_btn(view: android.view.View) {
//        val menu = Intent(this, Menu_en::class.java)
//        startActivity(menu);
    }
    fun learnWords(view: android.view.View) {
        val menu = Intent(this, LearnWordsActivity::class.java)
        startActivity(menu);
    }
    fun addWord(view: android.view.View) {
        val menu = Intent(this, Add_word_en::class.java)
        startActivity(menu);
    }
}