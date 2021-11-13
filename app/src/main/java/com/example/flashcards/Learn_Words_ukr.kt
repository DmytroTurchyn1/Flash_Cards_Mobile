package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmConfiguration

class Learn_Words_ukr : AppCompatActivity() {
    val realm by lazy{ Realm.getDefaultInstance()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words_ukr)
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .name("words.realm").build()


        Realm.setDefaultConfiguration(config)
    }

    fun menu(view: android.view.View) {
        val menu = Intent(this, Menu_ukr::class.java)
        startActivity(menu);
    }

    fun next(view: android.view.View) {
        var en_word = findViewById(R.id.enWord) as TextView

        realm.executeTransaction{

            val word: Word = realm.createObject(Word::class.java, 1)
            word.ukr_word = "ukr_word"
            word.en_word = "en_word"
        }
    val words = realm.where(Word::class.java).findAll()
        words.forEach{word ->
            en_word.text = word.en_word

        }
    }
    fun ShowUkrWord(view: android.view.View) {
        var ukr_word = findViewById(R.id.ukrWord) as TextView
        val words = realm.where(Word::class.java).findAll()
        words.forEach{word ->
            ukr_word.text = word.ukr_word

        }
    }
    }
