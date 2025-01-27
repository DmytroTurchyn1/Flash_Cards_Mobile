package com.app.flashcards.feature.irregularverbs

import com.app.flashcards.model.local.IrregularVerb
import com.app.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference
import kotlin.random.Random

class IrregularVerbsPresenter(view: IrregularVerbsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()
    private val wordsRepository = com.app.flashcards.repository.WordsRepository.getInstance()
    private var words = listOf<IrregularVerb>()
    private var id: Int = 0

    fun onActivityCreated() {
        words = wordsRepository.getIrregularVerbs()
        updateWordId()
    }

    fun onActivityStarted() = showNativeWord()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()

    fun onNextButtonClicked() {
        updateWordId()
        clearEnglishWord()
        showNativeWord()
    }

    private fun showNativeWord() = view?.showNativeWord(words[id].nativeWord)

    fun onShowForms() = view?.showVerbForms(words[id].firstForm, words[id].secondForm, words[id].thirdForm)

    private fun clearEnglishWord() = view?.showVerbForms(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING)

    private fun updateWordId() {
        id = getRandomId()
    }

    private fun getRandomId() = Random.nextInt(0, words.size)

    companion object {
        private const val EMPTY_STRING = ""
    }
}