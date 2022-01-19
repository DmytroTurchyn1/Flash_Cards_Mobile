package com.example.flashcards.feature.learnwords

interface LearnWordsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showEnglishWord(englishWord: String)

    fun showNoWordsError()
    fun close()
}