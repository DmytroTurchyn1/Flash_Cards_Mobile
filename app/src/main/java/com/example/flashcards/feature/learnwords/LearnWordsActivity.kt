package com.example.flashcards.feature.learnwords

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_learn_words.*

class LearnWordsActivity : AppCompatActivity(), LearnWordsView {


    private val presenter = LearnWordsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words)

        presenter.onActivityCreated()

        ibMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnNativeWord.setOnClickListener { presenter.onShowEnglishWordClicked() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
        btnDelete.setOnClickListener{presenter.DeleteWord()}
    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun showNativeWord(nativeWord: String) {
        btnNativeWord.text = nativeWord
    }

    override fun showEnglishWord(englishWord: String) {
        tvEnglishWord.text = englishWord
    }

    override fun DeleteWord() {
        val builder =  AlertDialog.Builder(this)
        builder.setTitle(R.string.word_delete_question)
            .setCancelable(false)
            .setPositiveButton(R.string.yes){
                    dialog, id -> presenter.DeleteWord()

            }
            .setNegativeButton(R.string.no){
                    dialog, id -> dialog.cancel()

            }
        builder.create()
        builder.show()
    }

    override fun showNoWordsError() =
        Toast.makeText(this, getString(R.string.no_user_word_error), Toast.LENGTH_SHORT).show()

    override fun close() = finish()
}