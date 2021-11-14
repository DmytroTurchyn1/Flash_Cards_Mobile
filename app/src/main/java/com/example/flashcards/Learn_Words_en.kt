package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmConfiguration

class Learn_Words_en : AppCompatActivity() {
    val realm by lazy { Realm.getDefaultInstance() }
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
        val menu = Intent(this, Menu_en::class.java)
        startActivity(menu);
    }

    open var id: Int = +1
    fun next(view: android.view.View) {
        try {
            var ukr_word = findViewById<TextView>(R.id.ukrWord)
            ukr_word.setVisibility(View.VISIBLE)
            id = +1
            val words = realm.where(Word::class.java).equalTo("id", id).findAll()
            words.forEach { word ->
                ukr_word.text = word.ukr_word

            }
        } catch (e: Exception) {
            val error =
                Toast.makeText(applicationContext, "There is an error!", Toast.LENGTH_SHORT)
            error.show()
        }
    }
        fun see_en_form(view: android.view.View) {
            try {

                var en_word = findViewById<TextView>(R.id.enWord)
                val words = realm.where(Word::class.java).equalTo("id", id).findAll()
                words.forEach { word ->
                    en_word.text = word.en_word

                }
            } catch (e: Exception) {
                val error =
                    Toast.makeText(applicationContext, "There is an error!", Toast.LENGTH_SHORT)
                error.show()
            }
        }

}