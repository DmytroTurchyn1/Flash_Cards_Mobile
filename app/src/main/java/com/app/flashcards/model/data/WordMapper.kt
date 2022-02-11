package com.app.flashcards.model.data

import com.app.flashcards.model.local.IrregularVerb
import com.app.flashcards.model.local.UserWord
import com.app.flashcards.model.local.SimpleWord
import io.realm.RealmResults

class WordMapper {
    fun mapUserWordsRealm(words: RealmResults<UserWordRealm>) =
        words.map { simpleWord ->
            UserWord(id = simpleWord.id, nativeWord = simpleWord.nativeWord, englishWord = simpleWord.englishWord)
        }

    fun mapIrregularVerbsRealm(words: RealmResults<IrregularVerbRealm>): List<IrregularVerb> {
        return words.map { irregularVerb ->
            IrregularVerb(id = irregularVerb.id,irregularVerb.nativeWord, irregularVerb.firstForm, irregularVerb.secondForm, irregularVerb.thirdForm )
        }
    }
    fun mapSimpleWordsRealm (words: RealmResults<SimpleWordsRealm>): List<SimpleWord> {
        return words.map { simplewords ->
            SimpleWord(id = simplewords.id, simplewords.nativeWord, simplewords.englishWord)
        }
    }
}