package com.app.flashcards.feature.aboutme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.flashcards.BuildConfig


import com.app.flashcards.util.Launcher
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityAboutMeBinding
import com.app.flashcards.databinding.ActivityMainBinding


class AboutMeActivity : AppCompatActivity(), AboutMeView {
    private lateinit var presenter: AboutMePresenter
    private lateinit var binding: ActivityAboutMeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = AboutMePresenter(this)

        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.btnGmail.setOnClickListener { presenter.onGmailBtnClicked() }
        binding.btnYoutube.setOnClickListener { presenter.onYoutubeBtnClicked() }
        binding.btnTelegram.setOnClickListener { presenter.onTelegramBtnClicked() }
        binding.tcVersion.text = "Version: " + BuildConfig.VERSION_NAME
    }
    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun navigateToTelegram() = Launcher.startTelegram(this)

    override fun navigateToGmail() = Launcher.startGmail(this)

    override fun navigateToYoutube() = Launcher.startYoutube(this)

}