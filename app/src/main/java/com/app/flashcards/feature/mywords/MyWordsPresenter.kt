package com.app.flashcards.feature.mywords

import java.lang.ref.WeakReference


class MyWordsPresenter(view: MyWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()
    fun onMainPageButtonClicked() = view?.navigateToMainActivity()

    fun onAddWordsButtonClicked() = view?.navigateToAddWordsActivity()

    fun onLearnWordsButtonClicked() = view?.navigateToLearnWordsActivity()
}