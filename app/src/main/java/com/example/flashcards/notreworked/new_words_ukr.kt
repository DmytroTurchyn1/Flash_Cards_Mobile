package com.example.flashcards.notreworked

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.flashcards.R
import com.example.flashcards.feature.menu.MenuActivity

class new_words_ukr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_words_ukr)

    }


    fun menu(view: android.view.View) {
        val menu = Intent(this, MenuActivity::class.java)
        startActivity(menu);

    }
    var next = 0
    fun ShowuUkrWord(view: android.view.View) {
        var ukr_word = findViewById<TextView>(R.id.btnShowEnglishWord)


        ukr_word.text = ukrWord[next]
    }
    open  val ukrWord = ArrayList<String>()
    open  val enWord = ArrayList<String>()
    fun next(view: View) {
        next ++
        var en_word = findViewById<TextView>(R.id.tvEnglishWord)
        var ukr_word = findViewById<TextView>(R.id.btnShowEnglishWord)
        en_word.setVisibility(View.VISIBLE)
        ukr_word.text =""
        en_word.text = ""
        enWord.add("time ");
        enWord.add("information");
        enWord.add("people");
        enWord.add("thing");
        enWord.add("man");
        enWord.add("woman");
        enWord.add("way");
        enWord.add("life");
        enWord.add("child");
        enWord.add("world");
        enWord.add("school");
        enWord.add("state");
        enWord.add("family");
        enWord.add("student");
        enWord.add("group");
        enWord.add("country");
        enWord.add("problem");
        enWord.add("hand");
        enWord.add("part");
        enWord.add("place");
        enWord.add("case");
        enWord.add("week");
        enWord.add("company");
        enWord.add("system");
        enWord.add("program");
        enWord.add("question");
        enWord.add("work");
        enWord.add("government");
        enWord.add("number");
        enWord.add("night");
        enWord.add("point");
        enWord.add("home");
        enWord.add("water");
        enWord.add("room");
        enWord.add("mother");
        enWord.add("area");
        enWord.add("money");
        enWord.add("story");
        enWord.add("fact");
        enWord.add("month");
        enWord.add("lot");
        enWord.add("right");
        enWord.add("study");
        enWord.add("book");
        enWord.add("eye");
        enWord.add("job");
        enWord.add("word");
        enWord.add("business");
        enWord.add("issue");

        ukrWord.add("час");
        ukrWord.add("   інформація");
        ukrWord.add("люди");
        ukrWord.add("річ");
        ukrWord.add(" чоловік");
        ukrWord.add("жінка");
        ukrWord.add("шлях");
        ukrWord.add("життя");
        ukrWord.add("дитина");
        ukrWord.add("світ");
        ukrWord.add("школа");
        ukrWord.add("держава");
        ukrWord.add("родина");
        ukrWord.add("студент");
        ukrWord.add("група");
        ukrWord.add("країна");
        ukrWord.add("проблема");
        ukrWord.add("рука");
        ukrWord.add("частина");
        ukrWord.add("місце");
        ukrWord.add("справа");
        ukrWord.add("тиждень");
        ukrWord.add("компанія");
        ukrWord.add("система");
        ukrWord.add("прогама");
        ukrWord.add("запитання");
        ukrWord.add("робота");
        ukrWord.add("уряд");
        ukrWord.add("число");
        ukrWord.add("ніч");
        ukrWord.add("точка");
        ukrWord.add("дім");
        ukrWord.add("вода");
        ukrWord.add("кімната");
        ukrWord.add("матір");
        ukrWord.add("площа");
        ukrWord.add("гроші");
        ukrWord.add("історія");
        ukrWord.add("факт");
        ukrWord.add("місяць");
        ukrWord.add("багато");
        ukrWord.add("правильно");
        ukrWord.add("вивчення");
        ukrWord.add("книга");
        ukrWord.add("око");
        ukrWord.add("робота");
        ukrWord.add("слово");
        ukrWord.add("бізнес");
        ukrWord.add("випуск");


        en_word.text = enWord[next]

    }
}