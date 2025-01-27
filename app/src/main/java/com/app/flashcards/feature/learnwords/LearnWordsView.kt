package com.app.flashcards.feature.learnwords

interface LearnWordsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showEnglishWord(englishWord: String)
    fun deleteWord()
    fun showNoWordsError()
    fun close()
}