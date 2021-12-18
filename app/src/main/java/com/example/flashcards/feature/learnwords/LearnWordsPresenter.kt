package com.example.flashcards.feature.learnwords

import com.example.flashcards.model.local.Word
import com.example.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference

class LearnWordsPresenter(view: LearnWordsView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    private val wordsRepository = WordsRepository.getInstance()
    private var words = listOf<Word>()
    open var id: Int = +1
    fun onActivityCreated() {
        words = wordsRepository.getWords()
    }

    fun onActivityStarted() {
        //show first word on screen
        view?.showNativeWord(words[id].nativeWord)
    }

    fun onShowEnlishWordClicked() {
        //show first word on screen
        view?.showEnglishWord(words[id].englishWord)
    }
    fun onNextButtonClicked() {
        //show first word on screen
        view?.showNativeWord(words[id].nativeWord)
    }
    fun onMenuBtnClicked() = view?.navigateToMenuActivity()

}
