package com.example.flashcards.util

import android.app.Activity
import android.content.Intent
import com.example.flashcards.feature.main.MainActivity
import com.example.flashcards.feature.menu.MenuActivity
import com.example.flashcards.notreworked.About_me_ukr
import com.example.flashcards.notreworked.Irregular_words_ukr
import com.example.flashcards.notreworked.My_words_ukr
import com.example.flashcards.notreworked.Settings_ukr

object Launcher {
    fun startMainActivity(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    fun startMenuActivity(activity: Activity) {
        val intent = Intent(activity, MenuActivity::class.java)
        activity.startActivity(intent)
    }

    fun startSettingsActivity(activity: Activity) {
        val settings = Intent(activity, Settings_ukr::class.java)
        activity.startActivity(settings)
    }

    fun startAboutProgramActivity(activity: Activity) {
        val intent = Intent(activity, About_me_ukr::class.java)
        activity.startActivity(intent)
    }

    fun startIrregularWordsActivity(activity: Activity) {
        val intent = Intent(activity, Irregular_words_ukr::class.java)
        activity.startActivity(intent)
    }

    fun startNewWordsUkr(activity: Activity) {
        val intent = Intent(activity, com.example.flashcards.notreworked.new_words_ukr::class.java)
        activity.startActivity(intent)
    }

    fun startMyWordsActivity(activity: Activity) {
        val intent = Intent(activity, My_words_ukr::class.java)
        activity.startActivity(intent)
    }
}