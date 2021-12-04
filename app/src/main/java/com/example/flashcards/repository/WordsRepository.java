package com.example.flashcards.repository;

import androidx.annotation.NonNull;
import com.example.flashcards.model.data.WordMapper;
import com.example.flashcards.model.data.WordRealm;
import com.example.flashcards.model.local.Word;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class WordsRepository implements IWordsRepository {
    private static IWordsRepository repository;
    private static Realm realm;
    private int primaryKey = 14;

    private WordsRepository() {
        realm = Realm.getDefaultInstance();
    }

    public static IWordsRepository getInstance() {
        if (repository == null) {
            repository = new WordsRepository();
        }
        return repository;
    }

    @Override
    public void saveWord(@NonNull Word word) {
        realm.executeTransaction(
                o -> {
                    WordRealm wordRealm = realm.createObject(WordRealm.class, primaryKey++);
                    wordRealm.setNativeWord(word.nativeWord);
                    wordRealm.setEnglishWord(word.englishWord);
                }
        );
    }

    @NonNull
    @Override
    public List<Word> getWords() {
        RealmResults<WordRealm> words = realm.where(WordRealm.class).findAll();
        WordMapper wordMapper = new WordMapper();
        return wordMapper.mapRealm(words);
    }
}
