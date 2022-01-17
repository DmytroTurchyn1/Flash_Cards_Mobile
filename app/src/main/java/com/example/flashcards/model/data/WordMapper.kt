package com.example.flashcards.model.data

import com.example.flashcards.model.local.IrregularVerb
import com.example.flashcards.model.local.UserWord
import com.example.flashcards.model.local.SimpleWord
import io.realm.RealmResults

class WordMapper {
    fun mapNewWordsRealm(words: RealmResults<UserWordRealm>) =
        words.map { simpleWord -> UserWord(nativeWord = simpleWord.nativeWord, englishWord = simpleWord.englishWord) }

    fun mapIrregularVerbsRealm(words: RealmResults<IrregularVerbRealm>): List<IrregularVerb> {
        return words.map { irregularVerb ->
            IrregularVerb(irregularVerb.nativeWord, irregularVerb.firstForm, irregularVerb.secondForm, irregularVerb.thirdForm)
        }
    }
    fun mapSimpleWordsRealm (words: RealmResults<SimpleWordsRealm>): List<SimpleWord> {
        return words.map { simplewords ->
            SimpleWord(simplewords.nativeWord, simplewords.englishWord)
        }
    }
}