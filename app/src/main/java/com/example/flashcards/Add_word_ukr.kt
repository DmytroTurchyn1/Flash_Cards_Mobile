package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary
import android.widget.EditText
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject

class Add_word_ukr : AppCompatActivity() {
    val realm by lazy{ Realm.getDefaultInstance()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word_ukr)
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
    open var primarykey = 5
    fun save(view: android.view.View) {
        primarykey++
        var ukr_word = findViewById<EditText>(R.id.ukr_word)
        var en_word = findViewById<EditText>(R.id.en_word)
        realm.executeTransaction{

            val word: Word = realm.createObject(Word::class.java, primarykey)
            word.ukr_word = ukr_word.text.toString()
            word.en_word =

                en_word.text.toString()
        }

    }
}