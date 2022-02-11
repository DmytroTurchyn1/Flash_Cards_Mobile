package com.app.flashcards.feature.newwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.app.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_new_words.*

class NewWordsActivity : AppCompatActivity(), NewWordsView {
    private lateinit var presenter: NewWordsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_words)

        presenter = NewWordsPresenter(this)
        presenter.onActivityCreated()

        btnEnglishWord.setOnClickListener { presenter.showNativeWord() }
        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showEnglishWord(englishWord: String) {
        btnEnglishWord.text = englishWord
    }

    override fun showNativeWord(nativeWord: String) {
        tvNativeWord.text = nativeWord
    }
}