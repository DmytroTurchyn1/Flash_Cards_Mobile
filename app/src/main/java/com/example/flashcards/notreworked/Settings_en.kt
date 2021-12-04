
package com.example.flashcards.notreworked

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcards.R
import com.example.flashcards.feature.main.MainActivity

class Settings_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_en)
    }
    fun Ukrainian(view: android.view.View) {
        val English_vercion = Intent(this, MainActivity::class.java)
        startActivity(English_vercion);
    }
    fun menu_btn(view: android.view.View) {
//        val menu = Intent(this, Menu_en::class.java)
//        startActivity(menu);
    }
}