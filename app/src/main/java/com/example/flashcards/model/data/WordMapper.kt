package com.example.flashcards.model.data

import com.example.flashcards.model.local.IrregularVerb
import com.example.flashcards.model.local.SimpleWord
import io.realm.RealmResults

class WordMapper {
    fun mapSimpleWordsRealm(words: RealmResults<SimpleWordRealm>) =
        words.map { simpleWord -> SimpleWord(nativeWord = simpleWord.nativeWord, englishWord = simpleWord.englishWord) }

    fun mapIrregularVerbsRealm(words: RealmResults<IrregularVerbRealm>): List<IrregularVerb> {
        return words.map { irregularVerb ->
            IrregularVerb(irregularVerb.nativeWord, irregularVerb.firstForm, irregularVerb.secondForm, irregularVerb.thirdForm)
        }
    }
}