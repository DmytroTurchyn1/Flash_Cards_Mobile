package com.example.flashcards.feature.main

import java.lang.ref.WeakReference

class MainPresenter(view: MainView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
}
