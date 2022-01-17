package com.example.flashcards.feature.newwords

interface NewWordsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showForms(englishWord: String)
}