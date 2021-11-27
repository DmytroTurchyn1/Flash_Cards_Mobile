package com.example.flashcards.feature.menu

import java.lang.ref.SoftReference

class MenuPresenter(view: MenuView) {
    private val viewReference = SoftReference(view)
    private val view
        get() = viewReference.get()

    fun onMainPageButtonClicked() = view?.navigateToMainActivity()
}
