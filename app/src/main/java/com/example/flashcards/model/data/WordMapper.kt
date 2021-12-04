package com.example.flashcards.model.data

import com.example.flashcards.model.local.Word
import io.realm.RealmResults

class WordMapper {
    fun mapRealm(words: RealmResults<WordRealm>) =
        words.map { Word(nativeWord = it.nativeWord, englishWord = it.englishWord) }
}