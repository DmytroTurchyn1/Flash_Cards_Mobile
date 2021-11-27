package com.example.flashcards.feature.menu

import java.lang.ref.SoftReference

class MenuPresenter(view: MenuView) {
    private val viewReference = SoftReference(view)
    private val view
        get() = viewReference.get()

    fun onMainPageButtonClicked() = view?.navigateToMainActivity()
    fun onNewWordsPageButtonClicked() = view?.navigateToMainActivity()
    fun onIrregularWordsPageButtonClicked() = view?.navigateToMainActivity()
    fun onMyWordsPageButtonClicked() = view?.navigateToMainActivity()
    fun onSettingsPageButtonClicked() = view?.navigateToMainActivity()
    fun onAboutProgramPageButtonClicked() = view?.navigateToMainActivity()
}
