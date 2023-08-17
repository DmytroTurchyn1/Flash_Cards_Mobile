package com.app.flashcards.feature.main

import android.content.Context
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityMainBinding
import com.app.flashcards.util.Launcher


class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ivLogo.setImageResource(R.drawable.logoflash_cards)
        presenter = MainPresenter(this)
        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)
}