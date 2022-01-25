package com.example.flashcards.model.local

import java.util.*


sealed class Word

data class UserWord(
    @JvmField
    val id: String = UUID.randomUUID().toString(),
    @JvmField
    val nativeWord: String,
    @JvmField
    val englishWord: String
) : Word()

data class IrregularVerb(
    @JvmField
    val id: String,
    @JvmField
    val nativeWord: String,
    @JvmField
    val firstForm: String,
    @JvmField
    val secondForm : String,
    @JvmField
    val thirdForm: String
) : Word()

data class SimpleWord(
    @JvmField
    val id: String,
    @JvmField
    val nativeWord: String,
    @JvmField
    val englishWord: String

) : Word()