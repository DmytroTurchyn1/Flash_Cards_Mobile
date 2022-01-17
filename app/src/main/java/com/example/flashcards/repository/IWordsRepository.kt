package com.example.flashcards.repository

import com.example.flashcards.model.local.IrregularVerb
import com.example.flashcards.model.local.NewWords
import com.example.flashcards.model.local.SimpleWord
import com.example.flashcards.model.local.Word

interface IWordsRepository {
    fun saveWord(word: Word)
    fun getWords(): List<SimpleWord>
    fun getIrregularVerbs(): List<IrregularVerb>
    fun getNewWords(): List<NewWords>
}