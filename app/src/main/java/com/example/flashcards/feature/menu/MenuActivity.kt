package com.example.flashcards.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.flashcards.*
import com.example.flashcards.util.Launcher


class MenuActivity : AppCompatActivity(), MenuView {
    private lateinit var presenter: MenuPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        presenter = MenuPresenter(this)
        val btnMainPage = findViewById<View>(R.id.btnMenu)
        btnMainPage.setOnClickListener { presenter.onMainPageButtonClicked() }
        val btnNewWords = findViewById<View>(R.id.btnNewWords)
        btnNewWords.setOnClickListener { presenter.onNewWordsPageButtonClicked() }
        val btnIrregularWords = findViewById<View>(R.id.btnIrregularWords)
        btnIrregularWords.setOnClickListener { presenter.onIrregularWordsPageButtonClicked() }
        val btnMyWords = findViewById<View>(R.id.btnMyWords)
        btnMyWords.setOnClickListener { presenter.onMyWordsPageButtonClicked() }
        val btnSettings = findViewById<View>(R.id.btnSettings)
        btnSettings.setOnClickListener { presenter.onSettingsPageButtonClicked() }
        val btnAboutProgram = findViewById<View>(R.id.btnAboutProgram)
        btnAboutProgram.setOnClickListener { presenter.onAboutProgramPageButtonClicked() }
    }

    override fun navigateToMainActivity() {
        Launcher.startMainActivity(this)
    }
    override fun navigateToNewWords() {
        Launcher.startNewWordsUkr(this)
    }override fun navigateToIrregularWords() {
        Launcher.startIrregularWordsActivity(this)
    }override fun navigateToMyWords() {
        Launcher.startMyWordsActivity(this)
    }override fun navigateToSettings() {
        Launcher.startSettingsActivity(this)
    }override fun navigateToAboutProgram() {
        Launcher.startAboutProgramActivity(this)
    }

    //    fun home_ukr(view: android.view.View) {
//        val home_ukr = Intent(this, MainActivity::class.java)
//        startActivity(home_ukr);
//    }
//    fun settings(view: android.view.View) {
//        val settings = Intent(this, Settings_ukr::class.java)
//        startActivity(settings);
//    }
//    fun about_program(view: android.view.View) {
//        val about_program = Intent(this, About_me_ukr::class.java)
//        startActivity(about_program);
//    }
//    fun irregular_words(view: android.view.View) {
//        val irregular_words = Intent(this, Irregular_words_ukr::class.java)
//        startActivity(irregular_words);
//    }
//    fun new_words_ukr(view: android.view.View) {
//        val new_words_ukr = Intent(this, com.example.flashcards.notreworked.new_words_ukr::class.java)
//        startActivity(new_words_ukr);
//    }
//    fun my_words(view: android.view.View) {
//        val my_words = Intent(this, My_words_ukr::class.java)
//        startActivity(my_words);
//    }
}