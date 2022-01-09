package com.example.flashcards.repository;

import androidx.annotation.NonNull;
import com.example.flashcards.model.data.WordMapper;
import com.example.flashcards.model.data.WordRealm;
import com.example.flashcards.model.local.Word;
import com.example.flashcards.util.RandomIdGenerator;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class WordsRepository implements IWordsRepository {
    private static IWordsRepository repository;
    private static Realm realm;
    private RandomIdGenerator idGenerator = new RandomIdGenerator();

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
                realm -> {
                    WordRealm wordRealm = new WordRealm(idGenerator.getId(), word.nativeWord, word.englishWord);
                    realm.insert(wordRealm);
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