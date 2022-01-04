package com.example.flashcards.feature.newwords

import java.lang.ref.WeakReference


class NewWordsPresenter(view: NewWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
}