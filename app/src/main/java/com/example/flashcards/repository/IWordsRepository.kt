package com.example.flashcards.repository

import com.example.flashcards.model.local.Word

interface IWordsRepository {
    fun saveWord(word: Word)
    fun getWords(): List<Word>
}