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
        btnNativeWord.setOnClickListener { presenter.onShowForms() }
        btnNext.setOnClickListener { presenter.onNextButtonClicked() }
    }

    override fun navigateToMenuActivity() = Launcher.startMenuActivity(this)

    override fun onStart() {
        super.onStart()
        presenter.onActivityStarted()
    }

    override fun showVerbForms(firsForm: String, secondForm: String, thirdForm: String) {
        tvFirstForm.text = firsForm
        tvSecondForm.text = secondForm
        tvThirdForm.text = thirdForm
    }

    override fun showNativeWord (nativeWord: String) {
        btnNativeWord.text = nativeWord
    }

   /* open  val ukrWord = ArrayList<String>()
    open  val enWord = ArrayList<String>()
    fun next(view: View) {
        next ++
        var en_word = findViewById<TextView>(R.id.ptEnglishWord)
        var ukr_word = findViewById<TextView>(R.id.ptEnglishWord)
        ukr_word.setVisibility(View.VISIBLE)
        ukr_word.text =""
        en_word.text = ""
        enWord.add("be	       was, were	   been");
        enWord.add("beat	          beat	       beaten");
        enWord.add("become	      became	   become");
        enWord.add("begin	      began	       begun");

        enWord.add("bleed	      bled	       bled");
        enWord.add(" blow	          blew         blown");
        enWord.add("break	      broke	       broken");
        enWord.add("bring	      brought	   brought");
        enWord.add("build	      built	       built");
        enWord.add("burn	          burnt	       burnt");
        enWord.add("burst	      burst	       burst");
        enWord.add("buy	          bought	   bought");
        enWord.add("catch	      caught	   caught");
        enWord.add("choose	      chose	       chosen");
        enWord.add("come	          came	       come");
        enWord.add("cost	          cost	       cost");
        enWord.add("creep	      crept	       crept");
        enWord.add("cut	          cut	       cut");
        enWord.add("do	          did	       done");
        enWord.add("draw	          drew	       drawn");
        enWord.add("dream	      dreamt	   dreamt");
        enWord.add("drink	      drank	       drunk");
        enWord.add("drive	      drove	       driven");
        enWord.add("eat	          ate	       eaten");
        enWord.add("fall	          fell	       fallen");
        enWord.add("feed	          fed	       fed");
        enWord.add("feel	          felt	       felt");
        enWord.add("fight	      fought	   fought");
        enWord.add("find	          found	       found");
        enWord.add("fit	          fit	       fit");
        enWord.add("fly	          flew	       flown");
        enWord.add("forget	      forgot	   forgotten");
        enWord.add("forgive	      forgave	   forgiven");
        enWord.add("freeze	      froze	       frozen");
        enWord.add("get	          got	       got");
        enWord.add("give        	  gave	       given");
        enWord.add("go	          went	       gone");
        enWord.add("grow	          grew	       grown");
        enWord.add("hang	          hung	       hung");
        enWord.add("have	          had	       had");
        enWord.add("hear	          heard	       heard");
        enWord.add("hide	          hid	       hidden");
        enWord.add("hit	          hit	       hit");
        enWord.add("hold	          held	       held");



        enWord.add("hurt	          hurt	       hurt");
        enWord.add("keep	          kept	       kept");
        enWord.add("kneel	      knelt	       knelt");
        enWord.add("know	          knew	       known");
        enWord.add("lay	          laid	       laid");
        enWord.add("lead	          led	       led");
        enWord.add("lean	          leant	       leant");
        enWord.add("learn	      learnt	   learnt");
        enWord.add("leave	      left	       left");
        enWord.add("lend	          lent	       lent");
        enWord.add("let	          let	       let");
        enWord.add("lie	          lay	       lain");
        enWord.add("light	      lit	       lit");
        enWord.add("lose	          lost	       lost");
        enWord.add("make	          made	       made");
        enWord.add("mean	          meant  	   meant");
        enWord.add("meet	          met	       met");
        enWord.add("mistake	      mistook	   mistaken");
        enWord.add("pay	          paid	       paid");
        enWord.add("prove	      proved	   proven");
        enWord.add("put	          put	       put");
        enWord.add("quit	          quit	       quit");
        enWord.add("read	          read	       read");
        enWord.add("ride	          rode	       ridden");
        enWord.add("ring	          rang	       rung");
        enWord.add("rise	          rose	       risen");
        enWord.add("run	          ran	       run");
        enWord.add("say            said	       said");
        enWord.add("see	          saw	       seen");
        enWord.add("seek	          sought	   sought");
        enWord.add("sell	          sold	       sold");
        enWord.add("send	          sent	       sent");
        enWord.add("set	          set	       set");
        enWord.add("sew	          sewed	       sewn");
        enWord.add("shake	      shook	       shaken");
        enWord.add("show	          showed	   shown");
        enWord.add("shrink	      shrank	   shrunk");
        enWord.add("shut	          shut	       shut");
        enWord.add("sing	          sang	       sung");
        enWord.add("sink	          sank	       sunk");
        enWord.add("sit	          sat	       sat");
        enWord.add("sleep	      slept	       slept");
        enWord.add("slide	      slid	       slid");
        enWord.add("sow	          sowed	       sown");
        enWord.add("speak	      spoke	       spoken");
        enWord.add("spell	      spelt	       spelt");
        enWord.add("spend	      spent	       spent");
        enWord.add("spill	      spilt   	   spilt");
        enWord.add("spoil	      spoilt	   spoilt");
        enWord.add("spread	      spread	   spread");
        enWord.add("spring	      sprang	   sprung");
        enWord.add("stand	      stood	       stood");
        enWord.add("steal	      stole	       stolen");
        enWord.add("stick	      stuck	       stuck");
        enWord.add("sting	      stung	       stung");
        enWord.add("sweep	      swept	       swept");
        enWord.add("swell	      swelled	   swollen");
        enWord.add("swim    	      swam	       swum");
        enWord.add("swing	      swung	       swung");
        enWord.add("take	          took	       taken");
        enWord.add("teach	      taught	   taught");
        enWord.add("tear    	      tore	       torn");
        enWord.add("tell	          told	       told");
        enWord.add("think	      thought	   thought");
        enWord.add("throw	      threw	       thrown");
        enWord.add("understand	  understood   understood");
        enWord.add("wake   	      woke	       woken");
        enWord.add("wear	          wore	       worn");
        enWord.add("weep	          wept	       wept");
        enWord.add("wet	          wet	       wet");
        enWord.add("win	          won	       won");
        enWord.add("write	      wrote	       written");

        ukrWord.add("бути");
        ukrWord.add("бити");
        ukrWord.add("ставати");
        ukrWord.add("починати");
        ukrWord.add("кровоточити");
        ukrWord.add("дути");
        ukrWord.add("ламати");
        ukrWord.add("приносити");
        ukrWord.add("будувати");
        ukrWord.add("горіти");
        ukrWord.add("вибухати");
        ukrWord.add("купувати");
        ukrWord.add("ловити");
        ukrWord.add("вибирати");
        ukrWord.add("приходити");
        ukrWord.add("коштувати");
        ukrWord.add("повзати");
        ukrWord.add("різати");
        ukrWord.add("робити");
        ukrWord.add("малювати");
        ukrWord.add("мріяти");
        ukrWord.add("пити");
        ukrWord.add("водити");
        ukrWord.add("є");
        ukrWord.add("падати");
        ukrWord.add("годувати");
        ukrWord.add("відчувати");
        ukrWord.add("боротися");
        ukrWord.add("знаходити");
        ukrWord.add("Підходить по розміру");
        ukrWord.add("літати");
        ukrWord.add("забувати");
        ukrWord.add("прощати");
        ukrWord.add("замерзати");
        ukrWord.add("отримувати");
        ukrWord.add("давати");
        ukrWord.add("йти");
        ukrWord.add("рости");
        ukrWord.add("вішати");
        ukrWord.add("мати");
        ukrWord.add("чути");
        ukrWord.add("ховати");
        ukrWord.add("Потрапляти в ціль");
        ukrWord.add("тримати");
        ukrWord.add("Завдати болю");
        ukrWord.add("тримати(Зберігати)");
        ukrWord.add("Стояти на колінах");
        ukrWord.add("знати");
        ukrWord.add("класти");
        ukrWord.add("вести");
        ukrWord.add("нахилятися");
        ukrWord.add("вчити");
        ukrWord.add("залишати");
        ukrWord.add("Давати у борг");
        ukrWord.add("дозволяти");
        ukrWord.add("лежати");
        ukrWord.add("висвітлювати");
        ukrWord.add("втрачати");
        ukrWord.add("виробляти");
        ukrWord.add("значить");
        ukrWord.add("зустрічати");
        ukrWord.add("помилятися");
        ukrWord.add("платити");
        ukrWord.add("надавати");
        ukrWord.add("покласти");
        ukrWord.add("залишати");
        ukrWord.add("Читати");
        ukrWord.add("Їздити верхи");
        ukrWord.add("дзвеніти");
        ukrWord.add("підніматися");
        ukrWord.add("бігти");
        ukrWord.add("говорити");
        ukrWord.add("Шукати");
        ukrWord.add("продавати");
        ukrWord.add("посилати(лист)");
        ukrWord.add("шити");
        ukrWord.add("струшувати");
        ukrWord.add("показувати");
        ukrWord.add("стискатися");
        ukrWord.add("закривати");
        ukrWord.add("співати");
        ukrWord.add("тонути");
        ukrWord.add("спати");
        ukrWord.add("ковзати");
        ukrWord.add("сіяти");
        ukrWord.add("говорити");
        ukrWord.add("Вимовляти по буквах");
        ukrWord.add("витрачати");
        ukrWord.add("проливати");
        ukrWord.add("псувати");
        ukrWord.add("розстеляти");
        ukrWord.add("стрибати");
        ukrWord.add("стояти");
        ukrWord.add("красти");
        ukrWord.add("колоти");
        ukrWord.add("жалити");
        ukrWord.add("вимітати");
        ukrWord.add("розбухати");
        ukrWord.add("плавати");
        ukrWord.add("качати");
        ukrWord.add("Брати, взяти");

        ukrWord.add("вчити");
        ukrWord.add("рвати");
        ukrWord.add("розповідати");
        ukrWord.add("думати");
        ukrWord.add("кидати");
        ukrWord.add("Розуміти");
        ukrWord.add("прокидатися");
        ukrWord.add("Носити (одяг)");
        ukrWord.add("плакати");
        ukrWord.add("писати");
        ukr_word.text = ukrWord[next]


    }
*/
}