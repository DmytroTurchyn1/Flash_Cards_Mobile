package com.app.flashcards.feature.newwords

interface NewWordsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showEnglishWord(englishWord: String)
}