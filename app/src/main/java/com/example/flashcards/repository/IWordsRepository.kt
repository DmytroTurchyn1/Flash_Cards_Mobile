package com.example.flashcards.repository

interface IWordsRepository {
    fun saveWord(nativeWord: String, englishWord: String)
    fun getWords(): Map<String, String>
}