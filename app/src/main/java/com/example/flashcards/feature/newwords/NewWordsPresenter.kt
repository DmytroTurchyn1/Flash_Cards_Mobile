package com.example.flashcards.feature.newwords

import com.example.flashcards.model.local.Word
import com.example.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference
import kotlin.random.Random


class NewWordsPresenter(view: NewWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()
    private val wordsRepository = WordsRepository.getInstance()
    private var words = listOf<Word>()
    private var id: Int = 0

    fun onActivityCreated() {
        words = wordsRepository.getWords()

    }

    fun onActivityStarted() = showEnglishWord()

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()

    fun onNextButtonClicked() {
        updateWordId()
        clearEnglishWord()
        showEnglishWord()
    }



    private fun onShowNativeWord() = view?.showNativeWord(words[id].nativeWord)

    fun showEnglishWord() = view?.showEnglishWord(words[id].englishWord)

    private fun clearEnglishWord() = view?.showEnglishWord(EMPTY_STRING)

    private fun updateWordId() {
        id = getRandomId()
    }

    private fun getRandomId() = Random.nextInt(0, words.size)

    companion object {
        private const val EMPTY_STRING = ""
    }
}