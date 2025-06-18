package com.app.flashcards.feature.menu

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.app.flashcards.util.Launcher


class MenuActivity : AppCompatActivity(), MenuView {
    private lateinit var presenter: MenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        presenter = MenuPresenter(this)
        setContent {
            MenuScreen(
                onAction = {
                    when (it) {
                        MenuAction.MAIN_PAGE -> presenter.onMainPageButtonClicked()
                        MenuAction.NEW_WORDS -> presenter.onNewWordsPageButtonClicked()
                        MenuAction.IRREGULAR_WORDS -> presenter.onIrregularWordsPageButtonClicked()
                        MenuAction.MY_WORDS -> presenter.onMyWordsPageButtonClicked()
                        MenuAction.ABOUT_PROGRAM -> presenter.onAboutProgramPageButtonClicked()
                    }

                }
            )
        }
    }

    override fun navigateToMainActivity() = Launcher.startMainActivity(this)

    override fun navigateToNewWordsActivity() = Launcher.startNewWords(this)

    override fun navigateToIrregularWordsActivity() = Launcher.startIrregularWordsActivity(this)

    override fun navigateToMyWordsActivity() = Launcher.startMyWordsActivity(this)

    override fun navigateToAboutProgramActivity() = Launcher.startAboutProgramActivity(this)
}