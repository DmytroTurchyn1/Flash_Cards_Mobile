package com.example.flashcards.feature.irregularverbs

interface IrregularVerbsView {
    fun navigateToMenuActivity()
    fun showNativeWord(nativeWord: String)
    fun showVerbForms(firsForm: String, secondForm: String, thirdForm: String)
}