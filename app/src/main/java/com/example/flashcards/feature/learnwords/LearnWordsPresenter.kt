package com.example.flashcards.feature.learnwords

import com.example.flashcards.model.local.UserWord
import com.example.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference
import kotlin.random.Random

class LearnWordsPresenter(view: LearnWordsView) {

    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    private val wordsRepository = WordsRepository.getInstance()
    private var words = listOf<UserWord>()
    private var id: Int = 0

    fun onActivityCreated() {
        words = wordsRepository.getWords()
        if(words.isEmpty()) {
            showErrorAndCloseActivity()
        } else {
            updateWordId()
        }
    }

    fun onActivityStarted() = showNativeWord()

    fun onShowEnglishWordClicked() = view?.showEnglishWord(words[id].englishWord)

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

    private fun showNativeWord() = view?.showNativeWord(words[id].nativeWord)

    private fun clearEnglishWord() = view?.showEnglishWord(EMPTY_STRING)

    private fun updateWordId() {
        id = getRandomId()
    }

     fun DeleteWord() {
         view?.DeleteWord()
         wordsRepository.DeleteWord(words[id].toString())
     }

    private fun getRandomId() = Random.nextInt(0, words.size)

    companion object {
        private const val EMPTY_STRING = ""
    }
}
