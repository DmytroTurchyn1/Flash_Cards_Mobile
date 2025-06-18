package com.app.flashcards.model.local

sealed class Words

data class NewWords(
    val native: String,
    val english: String
) : Words()

data class IrregularWords(
    val native: String,
    val firstForm: String,
    val secondForm: String,
    val thirdForm: String
) : Words()

