package com.example.flashcards.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
    }

    override fun navigateToAddWordActivity() {
        Launcher.startMenuActivity(this)
    }
}