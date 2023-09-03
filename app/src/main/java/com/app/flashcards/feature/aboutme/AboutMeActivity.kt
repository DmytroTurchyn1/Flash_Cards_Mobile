package com.app.flashcards.feature.aboutme


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.BuildConfig
import com.app.flashcards.databinding.ActivityAboutMeBinding
import com.app.flashcards.util.Launcher


class AboutMeActivity : AppCompatActivity(), AboutMeView {
    private lateinit var presenter: AboutMePresenter
    private lateinit var binding: ActivityAboutMeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = AboutMePresenter(this)
        println("hello!")
        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.btnGmail.setOnClickListener { presenter.onGmailBtnClicked() }
        binding.btnYoutube.setOnClickListener { presenter.onYoutubeBtnClicked() }
        binding.btnTelegram.setOnClickListener { presenter.onTelegramBtnClicked() }
        binding.tvVersion.text = "Version: " + BuildConfig.VERSION_NAME

    }
    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun navigateToTelegram() = Launcher.startTelegram(this)

    override fun navigateToGmail() = Launcher.startGmail(this)

    override fun navigateToYoutube() = Launcher.startYoutube(this)

}