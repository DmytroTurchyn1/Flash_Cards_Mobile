package com.example.flashcards.model.local

sealed class Words

data class NewWords(
    val native: String,
    val english: String
) : Words()

data class IrregularWords(
    val frstform: String,
    val secondform : String,
    val thirdform: String,
    val native: String
) : Words()


