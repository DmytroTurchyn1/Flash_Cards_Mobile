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
    private var id: Int = 1

    fun onActivityCreated() {
        words = wordsRepository.getWords()
    }

    fun onActivityStarted() = view?.showNativeWord(words[Random.nextInt(0, words.size)].nativeWord)

    fun onShowEnglishWordClicked() = view?.showEnglishWord(words[Random.nextInt(0, words.size)].englishWord)

    fun onNextButtonClicked() = view?.showNativeWord(words[Random.nextInt(0, words.size)].nativeWord)

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
}
