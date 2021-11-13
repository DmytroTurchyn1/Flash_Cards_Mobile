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
            .name("words.realm").build()
        Realm.setDefaultConfiguration(config)
        var ukr_word = findViewById(R.id.ukr_word) as EditText
        var en_word = findViewById(R.id.en_word) as EditText
        InsertDatatoDB(ukr_word.text.toString(),en_word.text.toString())
    }

    private fun InsertDatatoDB(ukr_word:String,en_word:String ) {
        realm.executeTransaction{

            val word: Word = realm.createObject(Word::class.java)
            word.ukr_word = ukr_word
            word.en_word = en_word
        }
    }

    fun menu(view: android.view.View) {
        val menu = Intent(this, Menu_ukr::class.java)
        startActivity(menu);
    }
}