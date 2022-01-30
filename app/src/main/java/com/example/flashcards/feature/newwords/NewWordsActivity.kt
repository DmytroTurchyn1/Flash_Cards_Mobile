package com.example.flashcards.feature.newwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_new_words.*

class NewWordsActivity : AppCompatActivity(), NewWordsView {
    private lateinit var presenter: NewWordsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_words)

        presenter = NewWordsPresenter(this)
        presenter.onActivityCreated()

        tvEnglishWord.setOnClickListener { presenter.showNativeWord() }
        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showEnglishWord(englishWord: String) {
        tvEnglishWord.text = englishWord
    }

    override fun showNativeWord(nativeWord: String) {
        btnNativeWord.text = nativeWord
    }
}