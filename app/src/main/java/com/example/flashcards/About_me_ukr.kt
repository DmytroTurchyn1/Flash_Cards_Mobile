package com.example.flashcards

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About_me_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me_ukr)
    }
    fun menu_btn(view: android.view.View) {
        val menu = Intent(this, Menu_ukr::class.java)
        startActivity(menu);
    }
    fun telegram(view: android.view.View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/dima8093556548"))
        startActivity(browserIntent)
    }
    fun youtube(view: android.view.View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC-nn4RFP16LjaWk8SRs15Pg"))
        startActivity(browserIntent)
    }
    fun gmail(view: android.view.View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:dim4ukt@gmail.com"))
        startActivity(browserIntent)
    }
}