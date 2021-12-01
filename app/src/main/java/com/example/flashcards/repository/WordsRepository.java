package com.example.flashcards.repository;

import androidx.annotation.NonNull;

import com.example.flashcards.feature.addword.AddWordActivity;
import com.example.flashcards.notreworked.Word;

import java.util.Map;

import io.realm.Realm;
import io.realm.RealmCollection;
import io.realm.RealmConfiguration;

public class WordsRepository implements IWordsRepository {
    private static IWordsRepository repository;
    private static Realm realm;
    private WordsRepository() {
        realm = Realm.getDefaultInstance();

        Realm.init(this);
            RealmConfiguration config = new RealmConfiguration.Builder();
                .allowWritesOnUiThread(true)
                .name("words.realm").build();


        Realm.setDefaultConfiguration(config);
    }

    public static IWordsRepository getInstance() {

        if (repository == null) {
            repository = new WordsRepository();
        }
        return repository;
    }

    @Override
    public void saveWord(@NonNull String nativeWord, @NonNull String englishWord) {
        realm.executeTransaction {

            Word word  = realm.createObject(Word::class.java, AddWordActivity.primarykey1.primarykey)
            word.ukr_word = nativeWord;
            word.en_word = englishWord;



        }
    }

    @NonNull
    @Override
    public Map<String, String> getWords()
    {
        Realm words = realm.where(Word::class.java).findAll();



    }
}
