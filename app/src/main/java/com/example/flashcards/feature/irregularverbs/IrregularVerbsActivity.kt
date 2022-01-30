package com.example.flashcards.feature.irregularverbs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.util.Launcher
import kotlinx.android.synthetic.main.activity_irregular_words.*

class IrregularVerbsActivity : AppCompatActivity(), IrregularVerbsView {
    private lateinit var presenter: IrregularVerbsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregular_words)

        presenter = IrregularVerbsPresenter(this)
        presenter.onActivityCreated()

        btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        tvNativeWord.setOnClickListener { presenter.onShowForms() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showVerbForms(firsForm: String, secondForm: String, thirdForm: String) {
        tvFirstform.text = firsForm
        tvSecondform.text = secondForm
        tvThirdform.text = thirdForm
    }

    override fun showNativeWord (nativeWord: String) {
        tvNativeWord.text = nativeWord
    }
}