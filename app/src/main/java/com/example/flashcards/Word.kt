package com.example.flashcards

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Word: RealmObject() {
    @PrimaryKey
    var id = 0
    var ukr_word =""
    var en_word =""



}