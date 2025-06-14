package com.app.flashcards.feature.newwords


import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.databinding.ActivityNewWordsBinding
import com.app.flashcards.util.Launcher


class NewWordsActivity : AppCompatActivity(), NewWordsView {
    private lateinit var presenter: NewWordsPresenter
    private lateinit var binding:ActivityNewWordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
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