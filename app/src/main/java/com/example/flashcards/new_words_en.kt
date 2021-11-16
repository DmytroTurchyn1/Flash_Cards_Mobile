package com.example.flashcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class new_words_en : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_words_en)
    }
    fun menu(view: android.view.View) {
        val menu = Intent(this, Menu_en::class.java)
        startActivity(menu);
    }
    var next = 0
    fun ShowUkrWord(view: android.view.View) {
        var en_Word = findViewById<TextView>(R.id.en_word)
        en_Word.text = ""

        en_Word.text = enWord[next]
    }
    open  val ukrWord = ArrayList<String>()
    open  val enWord = ArrayList<String>()
    fun next(view: android.view.View) {
        next ++
        var ukr_word = findViewById<TextView>(R.id.en_word)
        var en_Word = findViewById<TextView>(R.id.en_word)
        en_Word.text = ""
        ukr_word.setVisibility(View.VISIBLE)
        ukr_word.text = ""
        enWord.add("time ");
        enWord.add("information");
        enWord.add("  people");
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
        ukrWord.add("інформація");
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


        ukr_word.text = ukrWord[next]

    }
}