package com.example.flashcards.feature.aboutme

import com.example.flashcards.feature.learnwords.LearnWordsView
import java.lang.ref.WeakReference

class AboutMePresenter(view: AboutMeView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
    fun onGmailBtnClicked() = view?.navigateToGmail()
    fun onTelegramBtnClicked() = view?.navigateToTelegram()
    fun onYoutubeBtnClicked() = view?.navigateToYoutube()
}