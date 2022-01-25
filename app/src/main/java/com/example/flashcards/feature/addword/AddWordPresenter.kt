package com.example.flashcards.feature.addword

import com.example.flashcards.model.local.UserWord
import com.example.flashcards.repository.WordsRepository
import java.lang.ref.WeakReference

class AddWordPresenter (view: AddWordView){
    private val repository = WordsRepository.getInstance()
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