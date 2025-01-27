package com.app.flashcards.feature.addword

import com.app.flashcards.model.local.UserWord
import com.app.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference

class AddWordPresenter (view: AddWordView){
    private val repository = com.app.flashcards.repository.WordsRepository.getInstance()
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onSaveBtnClicked(nativeWord: String, englishWord: String) {
        repository.saveWord(UserWord(nativeWord = nativeWord, englishWord = englishWord))
        WordAdded()
    }

     fun WordAdded(){
         view?.close()
         view?.wordAdded()
     }

    fun onMenuBtnClicked() = view?.navigateToMenuActivity()
}