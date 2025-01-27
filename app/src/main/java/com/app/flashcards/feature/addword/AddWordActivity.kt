package com.app.flashcards.feature.addword

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.R
import com.app.flashcards.databinding.ActivityAddWordBinding
import com.app.flashcards.util.Launcher
import com.google.android.play.core.review.ReviewManagerFactory


class AddWordActivity : AppCompatActivity(), AddWordView {
    private lateinit var presenter: AddWordPresenter
    private lateinit var binding:ActivityAddWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = AddWordPresenter(this)

        binding.btnMenu.setOnClickListener { presenter.onMenuBtnClicked() }
        binding.btnSave.setOnClickListener {
            if (binding.ptNativeWord.text.toString() != "" && binding.tvFirstForm.text.toString() != ""){
            presenter.onSaveBtnClicked(binding.ptNativeWord.text.toString(),binding.tvFirstForm.text.toString())}
            else Toast.makeText(this, getString(R.string.input_words), Toast.LENGTH_SHORT).show()
        }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun wordAdded() {
        Toast.makeText(this, getString(R.string.word_added), Toast.LENGTH_SHORT).show()
        reviewRequest()
    }

    override fun close() = finish()

    override fun reviewRequest() {
        val reviewManager  = ReviewManagerFactory.create(applicationContext)
        reviewManager.requestReviewFlow().addOnCompleteListener(){
            if (it.isSuccessful){
                reviewManager.launchReviewFlow(this,it.result)
            }
        }
    }
}