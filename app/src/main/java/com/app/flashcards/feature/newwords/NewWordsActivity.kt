package com.app.flashcards.feature.newwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.flashcards.R

import com.app.flashcards.databinding.ActivityNewWordsBinding
import com.app.flashcards.util.Launcher


class NewWordsActivity : AppCompatActivity(), NewWordsView {
    private lateinit var presenter: NewWordsPresenter
    private lateinit var binding:ActivityNewWordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordsBinding.inflate(layoutInflater)

        presenter = NewWordsPresenter(this)
        presenter.onActivityCreated()
        setContentView(binding.root)
        binding.btnEnglishWord.setOnClickListener { presenter.showNativeWord() }
        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showEnglishWord(englishWord: String) {
        binding.btnEnglishWord.text = englishWord
    }

    override fun showNativeWord(nativeWord: String) {
        binding.tvNativeWord.text = nativeWord
    }
}