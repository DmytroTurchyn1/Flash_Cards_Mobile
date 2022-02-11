package com.app.flashcards.repository

import com.app.flashcards.model.local.*

interface IWordsRepository {
    fun saveWord(word: Word)
    fun getWords(): List<UserWord>
    fun getIrregularVerbs(): List<IrregularVerb>
    fun getSimpleWords(): MutableList<SimpleWord>
    fun deleteWord(id:String)
}