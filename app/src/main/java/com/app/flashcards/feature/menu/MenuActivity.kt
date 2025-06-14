package com.app.flashcards.feature.menu


import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.databinding.ActivityMenuBinding
import com.app.flashcards.util.Launcher


class MenuActivity : AppCompatActivity(), MenuView {
    private lateinit var presenter: MenuPresenter
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        // Inflate the binding layout first
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MenuPresenter(this)

        binding.btnMainPage.setOnClickListener { presenter.onMainPageButtonClicked() }

        binding.btnNewWords.setOnClickListener { presenter.onNewWordsPageButtonClicked() }

        binding.btnIrregularWords.setOnClickListener { presenter.onIrregularWordsPageButtonClicked() }

        binding.btnMyWords.setOnClickListener { presenter.onMyWordsPageButtonClicked() }

        binding.btnAboutProgram.setOnClickListener { presenter.onAboutProgramPageButtonClicked() }
    }

    override fun navigateToMainActivity() = Launcher.startMainActivity(this)

    override fun navigateToNewWordsActivity() = Launcher.startNewWords(this)

    override fun navigateToIrregularWordsActivity() = Launcher.startIrregularWordsActivity(this)

    override fun navigateToMyWordsActivity() = Launcher.startMyWordsActivity(this)

    override fun navigateToAboutProgramActivity() = Launcher.startAboutProgramActivity(this)
}