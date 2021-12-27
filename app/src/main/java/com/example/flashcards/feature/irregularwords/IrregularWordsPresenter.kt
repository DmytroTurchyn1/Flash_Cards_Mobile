package com.example.flashcards.feature.irregularwords


import java.lang.ref.WeakReference

class IrregularWordsPresenter(view: IrregularWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
}