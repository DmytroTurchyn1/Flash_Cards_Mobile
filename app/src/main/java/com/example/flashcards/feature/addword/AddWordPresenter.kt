package com.example.flashcards.feature.addword

import com.example.flashcards.model.local.Word
import com.example.flashcards.repository.WordsRepository

class AddWordPresenter {
    private val repository = WordsRepository.getInstance()

    fun onSaveBtnClicked(nativeWord: String, englishWord: String) {
        repository.saveWord(Word(nativeWord, englishWord))
    }

}