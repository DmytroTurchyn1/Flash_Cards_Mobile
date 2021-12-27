package com.example.flashcards.feature.mywords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_my_words_en.*

class MyWordsActivity : AppCompatActivity(), MyWordsView {
    private lateinit var presenter: MyWordsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_words_en)

        presenter = MyWordsPresenter(this)

        btnMenu.setOnClickListener { presenter.onMainPageButtonClicked() }

        btnAddWord.setOnClickListener { presenter.onAddWordsButtonClicked() }

        btnLearnWords.setOnClickListener { presenter.onLearnWordsButtonClicked() }
    }
    override fun navigateToMainActivity() = Launcher.startMenuActivity(this)

    override fun navigateToAddWordsActivity() = Launcher.startAddWordActivity(this)

    override fun navigateToLearnWordsActivity() = Launcher.startLearnWordsActivity(this)
}