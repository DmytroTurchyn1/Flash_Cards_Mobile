package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmConfiguration

class Learn_Words_en : AppCompatActivity() {
    val realm by lazy{ Realm.getDefaultInstance()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words_en)
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
    open var id:Int =+ 1
    fun next(view: android.view.View) {
        var ukr_word = findViewById<TextView>(R.id.ukrWord)

        id =+1
        val words = realm.where(Word::class.java).equalTo("id", id).findAll()
        words.forEach{word ->
            ukr_word.text = word.ukr_word

        }
    }
    fun see_en_form(view: android.view.View) {
        var en_word = findViewById<TextView>(R.id.enWord)
        val words = realm.where(Word::class.java).equalTo("id", id).findAll()
        words.forEach{word ->
            en_word.text = word.en_word

        }
    }
}