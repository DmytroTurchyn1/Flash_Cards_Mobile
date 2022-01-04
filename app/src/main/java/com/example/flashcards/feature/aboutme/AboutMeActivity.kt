package com.example.flashcards.feature.aboutme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_about_me_ukr.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnMenu

class AboutMeActivity : AppCompatActivity(), AboutMeView {
    private lateinit var presenter: AboutMePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me_ukr)
        presenter = AboutMePresenter(this)

        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnGmail.setOnClickListener { presenter.onGmailBtnClicked() }
        btnYoutube.setOnClickListener { presenter.onYoutubeBtnClicked() }
        btnTelegram.setOnClickListener { presenter.onTelegramBtnClicked() }
    }
    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun navigateToTelegram() = Launcher.startTelegram(this)

    override fun navigateToGmail() = Launcher.startGmail(this)

    override fun navigateToYoutube() = Launcher.startYoutube(this)

}