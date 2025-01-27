package com.app.flashcards.feature.learnwords

import com.app.flashcards.model.local.UserWord
import com.app.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference
import kotlin.random.Random

class LearnWordsPresenter(view: LearnWordsView) {

    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    private val wordsRepository = com.app.flashcards.repository.WordsRepository.getInstance()
    private var words = listOf<UserWord>()
    private var index: Int = 0

    fun onActivityCreated() {
        words = wordsRepository.getWords()
        if (words.isEmpty()) {
            showErrorAndCloseActivity()
        } else {
            updateWordId()
        }
    }

    fun onActivityStarted() = showNativeWord()

    fun onShowEnglishWordClicked() = view?.showEnglishWord(words[index].englishWord)

    fun onNextButtonClicked() {
        updateWordId()
        clearEnglishWord()
        showNativeWord()
    }

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()

    private fun showErrorAndCloseActivity() {
        view?.showNoWordsError()
        view?.close()
    }

    private fun showNativeWord() = view?.showNativeWord(words[index].nativeWord)

    private fun clearEnglishWord() = view?.showEnglishWord(EMPTY_STRING)

    private fun updateWordId() {
        index = getRandomIndex()
    }

    private fun getRandomIndex() = Random.nextInt(0, words.size)

    fun onDeleteWordBtnClicked() {
        view?.deleteWord()
    }

    fun onDeleteWordConfirmed() = wordsRepository.deleteWord(words[index].id)

    companion object {
        private const val EMPTY_STRING = ""
    }
}
