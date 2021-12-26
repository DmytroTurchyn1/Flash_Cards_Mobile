package com.example.flashcards.feature.learnwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_learn_words.*

class LearnWordsActivity : AppCompatActivity(), LearnWordsView {

    private val presenter = LearnWordsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words)

        presenter.onActivityCreated()

        ibMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnShowNativeWord.setOnClickListener { presenter.onShowEnglishWordClicked() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun showNativeWord(nativeWord: String) {
        btnShowNativeWord.text = nativeWord
    }

    override fun showEnglishWord(englishWord: String) {
        tvEnglishWord.text = englishWord
    }
}