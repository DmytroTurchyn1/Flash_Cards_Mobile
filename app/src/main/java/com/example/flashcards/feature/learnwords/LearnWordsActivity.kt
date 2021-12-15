package com.example.flashcards.feature.learnwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_learn_words.*

class LearnWordsActivity : AppCompatActivity(), LearnWordsView {

    private val presenter = LearnWordsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words)

        presenter.onActivityCreated()

        ibMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnShowEnglishWord.setOnClickListener { presenter.onShowEnlishWordClicked }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }



    open var id: Int = +1
    fun next(view: android.view.View) {
//        try {
//            var ukr_word = findViewById<TextView>(R.id.ukrWord)
//            ukr_word.setVisibility(View.VISIBLE)
//            id = +1
//            val words = realm.where(Word::class.java).equalTo("id", id).findAll()
//            words.forEach { word ->
//                ukr_word.text = word.nativeWord
//
//            }
//        } catch (e: Exception) {
//            val error =
//                Toast.makeText(applicationContext, "There is an error!", Toast.LENGTH_SHORT)
//            error.show()
//        }
    }
        fun see_en_form(view: android.view.View) {
//            try {
//
//                var en_word = findViewById<TextView>(R.id.enWord)
//                val words = realm.where(Word::class.java).equalTo("id", id).findAll()
//                words.forEach { word ->
//                    en_word.text = word.englishWord
//
//                }
//            } catch (e: Exception) {
//                val error =
//                    Toast.makeText(applicationContext, "There is an error!", Toast.LENGTH_SHORT)
//                error.show()
//            }
        }

}