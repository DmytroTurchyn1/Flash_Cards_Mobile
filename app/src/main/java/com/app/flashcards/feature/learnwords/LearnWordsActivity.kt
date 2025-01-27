package com.app.flashcards.feature.learnwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityLearnWordsBinding
import com.app.flashcards.util.Launcher


class LearnWordsActivity : AppCompatActivity(), LearnWordsView {

    private var dialog: AlertDialog? = null
    private val presenter = LearnWordsPresenter(this)
    private lateinit var binding:ActivityLearnWordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.onActivityCreated()

        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.tvNativeWord.setOnClickListener { presenter.onShowEnglishWordClicked() }
        binding.btnNext.setOnClickListener { presenter.onNextButtonClicked() }
        binding.btnDelete.setOnClickListener { presenter.onDeleteWordBtnClicked() }
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
        binding.tvNativeWord.text = nativeWord
    }

    override fun showEnglishWord(englishWord: String) {
        binding.btnEnglishWord.text = englishWord
    }

    override fun deleteWord() {
        dialog = AlertDialog.Builder(this)
            .apply {
                setTitle(R.string.word_delete_question)
                setCancelable(false)
                setPositiveButton(R.string.yes) { dialog, _ ->
                    presenter.onDeleteWordConfirmed()
                    showinfo()
                    dialog.cancel()
                }
                setNegativeButton(R.string.no) { dialog, _ -> dialog.cancel() }
            }
            .create()
            .also {
                it.show()
            }
    }
    fun showinfo(){
        Toast.makeText(this, getString(R.string.word_deleted), Toast.LENGTH_SHORT).show()
        presenter.onMenuBtnClicked()
    }
    override fun showNoWordsError() =
        Toast.makeText(this, getString(R.string.no_user_word_error), Toast.LENGTH_SHORT).show()

    override fun close() = finish()
}