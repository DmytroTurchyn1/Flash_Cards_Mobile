package com.example.flashcards.repository;

import androidx.annotation.NonNull;
import com.example.flashcards.model.data.IrregularVerbRealm;
import com.example.flashcards.model.data.NewWordsRealm;
import com.example.flashcards.model.data.WordMapper;
import com.example.flashcards.model.data.SimpleWordRealm;
import com.example.flashcards.model.local.IrregularVerb;
import com.example.flashcards.model.local.NewWords;
import com.example.flashcards.model.local.SimpleWord;
import com.example.flashcards.model.local.Word;
import com.example.flashcards.util.RandomIdGenerator;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class WordsRepository implements IWordsRepository {
    private static IWordsRepository repository;
    private static Realm realm;
    private RandomIdGenerator idGenerator = new RandomIdGenerator();
    private WordMapper wordMapper = new WordMapper();

    private WordsRepository() {
        realm = Realm.getDefaultInstance();
        saveIrregularVerb(new IrregularVerb("Бути", "Be", "Was/Were", "Been"));

    }

    public static IWordsRepository getInstance() {
        if (repository == null) {
            repository = new WordsRepository();
        }
        return repository;
    }

    @Override
    public void saveWord(@NonNull Word word) {
        if (word instanceof SimpleWord) {
            saveSimpleWord((SimpleWord) word);
        } else if (word instanceof IrregularVerb) {
            saveIrregularVerb((IrregularVerb) word);
       } else if (word instanceof NewWords) {
            saveNewWords((NewWords) word);
//        else (word instanceof UserWord) {
//            saveUserWord();
        }
    }

    private void saveIrregularVerb(IrregularVerb word) {
        realm.executeTransaction(
                realm -> {
                    IrregularVerbRealm wordRealm = new IrregularVerbRealm(idGenerator.getId(), word.nativeWord, word.firstForm, word.secondForm, word.thirdForm);
                    realm.insert(wordRealm);
                }
        );
    }

    private void saveNewWords(NewWords word) {
        realm.executeTransaction(
                realm -> {
                    NewWordsRealm wordRealm = new NewWordsRealm(idGenerator.getId(), word.nativeWord, word.englishWord);
                    realm.insert(wordRealm);
                }
        );
    }

    private void saveSimpleWord(SimpleWord word) {
        realm.executeTransaction(
                realm -> {
                    SimpleWordRealm wordRealm = new SimpleWordRealm(idGenerator.getId(), word.nativeWord, word.englishWord);
                    realm.insert(wordRealm);
                }
        );
    }

    @NonNull
    @Override
    public List<SimpleWord> getWords() {
        RealmResults<SimpleWordRealm> words = realm.where(SimpleWordRealm.class).findAll();
        return wordMapper.mapSimpleWordsRealm(words);
    }

    @NonNull
    @Override
    public List<IrregularVerb> getIrregularVerbs() {
        RealmResults<IrregularVerbRealm> words = realm.where(IrregularVerbRealm.class).findAll();
        return wordMapper.mapIrregularVerbsRealm(words);
    }

    @NonNull
    @Override
    public List<NewWords> getNewWords() {
        RealmResults<NewWordsRealm> words = realm.where(NewWordsRealm.class).findAll();
        return wordMapper.mapNewWordsRealm(words);
    }
}