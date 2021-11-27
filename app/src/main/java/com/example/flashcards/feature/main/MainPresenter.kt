package com.example.flashcards.feature.main

import java.lang.ref.SoftReference

class MainPresenter(view: MainView) {
    private val viewReference = SoftReference(view)
    private val view
        get() = viewReference.get()

    fun onMenuBtnClicked() = view?.navigateToAddWordActivity()
}
