package com.app.flashcards.feature.irregularverbs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityIrregularWordsBinding
import com.app.flashcards.util.Launcher


class IrregularVerbsActivity : AppCompatActivity(), IrregularVerbsView {
    private lateinit var presenter: IrregularVerbsPresenter
    private lateinit var binding:ActivityIrregularWordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIrregularWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = IrregularVerbsPresenter(this)
        presenter.onActivityCreated()

        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.tvNativeWord.setOnClickListener { presenter.onShowForms() }
        binding.btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showVerbForms(firsForm: String, secondForm: String, thirdForm: String) {
        binding.tvFirstform.text = firsForm
        binding.tvSecondform.text = secondForm
        binding.tvThirdform.text = thirdForm
    }

    override fun showNativeWord (nativeWord: String) {
        binding.tvNativeWord.text = nativeWord
    }
}