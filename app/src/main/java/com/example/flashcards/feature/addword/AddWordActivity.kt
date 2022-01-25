package com.example.flashcards.feature.addword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.activity_main.btnMenu

class AddWordActivity : AppCompatActivity(), AddWordView {
    private lateinit var presenter: AddWordPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        presenter = AddWordPresenter(this)

        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        btnSave.setOnClickListener {
            presenter.onSaveBtnClicked(ptNativeWord.text.toString(), tvFirstForm.text.toString())
        }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun wordAdded() {
        Toast.makeText(this, getString(R.string.word_added), Toast.LENGTH_SHORT).show()

    }

    override fun close() = finish()
}