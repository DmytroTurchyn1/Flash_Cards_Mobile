package com.app.flashcards.repository

import com.app.flashcards.model.local.IrregularVerb
import com.app.flashcards.model.local.SimpleWord
import com.app.flashcards.model.local.UserWord
import com.app.flashcards.model.local.Word

interface IWordsRepository {
    fun saveWord(word: Word)
    fun getWords(): List<UserWord>
    fun getIrregularVerbs(): List<IrregularVerb>
    fun getSimpleWords(): MutableList<SimpleWord>
    fun deleteWord(id:String)
}