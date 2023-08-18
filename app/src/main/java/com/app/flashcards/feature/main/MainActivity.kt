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
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener


class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdView: AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ivLogo.setImageResource(R.drawable.logoflash_cards)
        presenter = MainPresenter(this)
        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        initAdmob()
    }

    override fun onResume() {
        super.onResume()
        binding.adView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.adView.destroy()
    }
    override fun onPause() {
        super.onPause()
        binding.adView.pause()
    }


    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)
    override fun initAdmob() {
        MobileAds.initialize(this)
        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}