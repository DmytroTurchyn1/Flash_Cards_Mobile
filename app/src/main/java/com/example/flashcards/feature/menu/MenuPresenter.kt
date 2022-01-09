package com.example.flashcards.feature.menu

import java.lang.ref.WeakReference

class MenuPresenter(view: MenuView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onMainPageButtonClicked() = view?.navigateToMainActivity()

    fun onNewWordsPageButtonClicked() = view?.navigateToNewWordsActivity()

    fun onIrregularWordsPageButtonClicked() = view?.navigateToIrregularWordsActivity()

    fun onMyWordsPageButtonClicked() = view?.navigateToMyWordsActivity()

    fun onAboutProgramPageButtonClicked() = view?.navigateToAboutProgramActivity()
}
