package com.app.flashcards.feature.mywords

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.databinding.ActivityMyWordsBinding
import com.app.flashcards.util.Launcher


class MyWordsActivity : AppCompatActivity(), MyWordsView {
    private lateinit var presenter: MyWordsPresenter
    private lateinit var binding: ActivityMyWordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityMyWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MyWordsPresenter(this)

        binding.btnMenu.setOnClickListener { presenter.onMainPageButtonClicked() }

        binding.btnAddWord.setOnClickListener { presenter.onAddWordsButtonClicked() }

        binding.btnLearnWords.setOnClickListener { presenter.onLearnWordsButtonClicked() }
    }
    override fun navigateToMainActivity() = Launcher.startMenuActivity(this)

    override fun navigateToAddWordsActivity() = Launcher.startAddWordActivity(this)

    override fun navigateToLearnWordsActivity() = Launcher.startLearnWordsActivity(this)
}