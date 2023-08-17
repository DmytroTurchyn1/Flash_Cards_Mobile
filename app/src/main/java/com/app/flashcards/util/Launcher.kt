package com.app.flashcards.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.app.flashcards.feature.main.MainActivity
import com.app.flashcards.feature.menu.MenuActivity
import com.app.flashcards.feature.aboutme.AboutMeActivity
import com.app.flashcards.feature.addword.AddWordActivity
import com.app.flashcards.feature.learnwords.LearnWordsActivity
import com.app.flashcards.feature.newwords.NewWordsActivity
import com.app.flashcards.feature.irregularverbs.IrregularVerbsActivity
import com.app.flashcards.feature.mywords.MyWordsActivity

object Launcher {
    fun startMainActivity(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    fun startMenuActivity(activity: Activity) {
        val intent = Intent(activity, MenuActivity::class.java)
        activity.startActivity(intent)
    }

    fun startAboutProgramActivity(activity: Activity) {
        val intent = Intent(activity, AboutMeActivity::class.java)
        activity.startActivity(intent)
    }

    fun startIrregularWordsActivity(activity: Activity) {
        val intent = Intent(activity, IrregularVerbsActivity::class.java)
        activity.startActivity(intent)
    }

    fun startAddWordActivity(activity: Activity) {
        val intent = Intent(activity, AddWordActivity::class.java)
        activity.startActivity(intent)
    }

    fun startLearnWordsActivity(activity: Activity) {
        val intent = Intent(activity, LearnWordsActivity::class.java)
        activity.startActivity(intent)
    }

    fun startNewWords(activity: Activity) {
        val intent = Intent(activity, NewWordsActivity::class.java)
        activity.startActivity(intent)
    }

    fun startMyWordsActivity(activity: Activity) {
        val intent = Intent(activity, MyWordsActivity::class.java)
        activity.startActivity(intent)
    }

    fun startTelegram(activity: Activity) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/Dima_labs_Cahnnel"))
        activity.startActivity(intent)
    }

    fun startGmail(activity: Activity) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:dim4ukt@gmail.com"))
        activity.startActivity(intent)
    }

    fun startYoutube(activity: Activity) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC-nn4RFP16LjaWk8SRs15Pg"))
        activity.startActivity(intent)
    }
}