package com.example.flashcards.model.local


sealed class Word

data class SimpleWord(
    @JvmField
    val nativeWord: String,
    @JvmField
    val englishWord: String
) : Word()

data class IrregularVerb(
    @JvmField
    val nativeWord: String,
    @JvmField
    val firstForm: String,
    @JvmField
    val secondForm : String,
    @JvmField
    val thirdForm: String
) : Word()

data class newwords(
    @JvmField
    val nativeWord: String,
    @JvmField
    val englishWord: String,

) : Word()