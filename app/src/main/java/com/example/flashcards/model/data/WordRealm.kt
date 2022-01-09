package com.example.flashcards.model.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import org.bson.types.ObjectId

@RealmClass
open class WordRealm(
    @PrimaryKey
    var id: String = ObjectId().toHexString(),
    @Required
    var nativeWord: String = "",
    @Required
    var englishWord: String = ""
) : RealmObject()