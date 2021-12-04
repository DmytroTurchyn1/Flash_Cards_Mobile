package com.example.flashcards.model.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class WordRealm : RealmObject() {
    @PrimaryKey
    var id = 0
    var nativeWord = ""
    var englishWord = ""
}