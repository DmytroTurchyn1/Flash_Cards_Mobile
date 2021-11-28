package com.example.flashcards.feature.addword

import com.example.flashcards.repository.WordsRepository

class AddWordPresenter {
    private val repository = WordsRepository.getInstance()

    fun something() {
        repository.getWords()
    }
}