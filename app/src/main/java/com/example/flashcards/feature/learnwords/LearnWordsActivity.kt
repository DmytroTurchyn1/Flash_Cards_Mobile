package com.example.flashcards.feature.learnwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_learn_words.*

class LearnWordsActivity : AppCompatActivity(), LearnWordsView {

    private var dialog: AlertDialog? = null
    private val presenter = LearnWordsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_words)

        presenter.onActivityCreated()

        ibMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnNativeWord.setOnClickListener { presenter.onShowEnglishWordClicked() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
        btnDelete.setOnClickListener { presenter.onDeleteWordBtnClicked() }
    }

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun onStop() {
        dialog?.dismiss()
        super.onStop()
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun showNativeWord(nativeWord: String) {
        btnNativeWord.text = nativeWord
    }

    override fun showEnglishWord(englishWord: String) {
        tvEnglishWord.text = englishWord
    }

    override fun deleteWord() {
        dialog = AlertDialog.Builder(this)
            .apply {
                setTitle(R.string.word_delete_question)
                setCancelable(false)
                setPositiveButton(R.string.yes) { dialog, _ ->
                    presenter.onDeleteWordConfirmed()
                    dialog.cancel()
                }
                setNegativeButton(R.string.no) { dialog, _ -> dialog.cancel() }
            }
            .create()
            .also {
                it.show()
            }
    }

    override fun showNoWordsError() =
        Toast.makeText(this, getString(R.string.no_user_word_error), Toast.LENGTH_SHORT).show()

    override fun close() = finish()
}