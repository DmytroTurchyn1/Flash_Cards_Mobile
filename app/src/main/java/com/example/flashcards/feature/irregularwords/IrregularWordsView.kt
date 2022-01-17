package com.example.flashcards.feature.irregularwords

interface IrregularWordsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showForms(englishWord: String)
}