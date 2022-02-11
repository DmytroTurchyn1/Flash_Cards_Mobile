package com.app.flashcards.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.*
import com.app.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity(), MenuView {
    private lateinit var presenter: MenuPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        presenter = MenuPresenter(this)

        btnMainPage.setOnClickListener { presenter.onMainPageButtonClicked() }

        btnNewWords.setOnClickListener { presenter.onNewWordsPageButtonClicked() }

        btnIrregularWords.setOnClickListener { presenter.onIrregularWordsPageButtonClicked() }

        btnMyWords.setOnClickListener { presenter.onMyWordsPageButtonClicked() }

        btnAboutProgram.setOnClickListener { presenter.onAboutProgramPageButtonClicked() }
    }

    override fun navigateToMainActivity() = Launcher.startMainActivity(this)

    override fun navigateToNewWordsActivity() = Launcher.startNewWords(this)

    override fun navigateToIrregularWordsActivity() = Launcher.startIrregularWordsActivity(this)

    override fun navigateToMyWordsActivity() = Launcher.startMyWordsActivity(this)

    override fun navigateToAboutProgramActivity() = Launcher.startAboutProgramActivity(this)
}