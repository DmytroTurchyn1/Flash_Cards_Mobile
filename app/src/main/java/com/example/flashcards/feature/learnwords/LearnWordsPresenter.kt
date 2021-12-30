package com.example.flashcards.feature.learnwords

import com.example.flashcards.model.local.Word
import com.example.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference
import kotlin.random.Random
import io.realm.annotations.PrimaryKey

class LearnWordsPresenter(view: LearnWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    private val wordsRepository = WordsRepository.getInstance()
    private var words = listOf<Word>()
    private var id: Int = getRandomId()

    fun onActivityCreated() {
        words = wordsRepository.getWords()
    }

    fun onActivityStarted() = showNativeWord()

    private fun showNativeWord() = view?.showNativeWord(words[id].nativeWord)

    fun onShowEnglishWordClicked() = view?.showEnglishWord(words[id].englishWord)

    fun onNextButtonClicked() {
        updateWordId()
        showNativeWord()
    }

    private fun updateWordId() {
        id = getRandomId()
    }

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()

    private fun getRandomId() = Random.nextInt(0, words.size)
}
