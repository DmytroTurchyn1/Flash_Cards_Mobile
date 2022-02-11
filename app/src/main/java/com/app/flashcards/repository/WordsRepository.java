package com.app.flashcards.repository;

import androidx.annotation.NonNull;

import com.app.flashcards.model.data.IrregularVerbRealm;
import com.app.flashcards.model.data.SimpleWordsRealm;
import com.app.flashcards.model.data.UserWordRealm;
import com.app.flashcards.model.data.WordMapper;
import com.app.flashcards.model.local.IrregularVerb;
import com.app.flashcards.model.local.SimpleWord;
import com.app.flashcards.model.local.UserWord;
import com.app.flashcards.model.local.Word;
import com.app.flashcards.util.RandomIdGenerator;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class WordsRepository implements IWordsRepository {
    private static final String ID = "id";
    private static IWordsRepository repository;
    private static Realm realm;
    private final RandomIdGenerator idGenerator = new RandomIdGenerator();
    private final WordMapper wordMapper = new WordMapper();

    private WordsRepository() {
        realm = Realm.getDefaultInstance();
        //saveIrregularVerb(new IrregularVerb(idGenerator.getId(), "Бути", "Be", "Was/Were", "Been"));
        //saveSimpleWords(new SimpleWord(idGenerator.getId(), "Бути", "Be"));
    }

    public static IWordsRepository getInstance() {
        if (repository == null) {
            repository = new WordsRepository();
        }
        return repository;
    }

    @Override
    public void saveWord(@NonNull Word word) {
        if (word instanceof UserWord) {
            saveUserWords((UserWord) word);
        } else if (word instanceof IrregularVerb) {
            saveIrregularVerb((IrregularVerb) word);
        } else if (word instanceof SimpleWord) {
            saveSimpleWords((SimpleWord) word);
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

    private void saveSimpleWords(SimpleWord word) {
        realm.executeTransaction(
                realm -> {
                    SimpleWordsRealm wordRealm = new SimpleWordsRealm(idGenerator.getId(), word.nativeWord, word.englishWord);
                    realm.insert(wordRealm);
                }
        );
    }

    private void saveUserWords(UserWord word) {
        realm.executeTransaction(
                realm -> {
                    UserWordRealm wordRealm = new UserWordRealm(idGenerator.getId(), word.nativeWord, word.englishWord);
                    realm.insert(wordRealm);
                }
        );
    }

    @NonNull
    @Override
    public List<UserWord> getWords() {
        RealmResults<UserWordRealm> words = realm.where(UserWordRealm.class).findAll();
        return wordMapper.mapUserWordsRealm(words);
    }

    @NonNull
    @Override
    public List<IrregularVerb> getIrregularVerbs() {
        RealmResults<IrregularVerbRealm> words = realm.where(IrregularVerbRealm.class).findAll();
        return wordMapper.mapIrregularVerbsRealm(words);
    }

    @NonNull
    @Override
    public List<SimpleWord> getSimpleWords() {
        RealmResults<SimpleWordsRealm> words = realm.where(SimpleWordsRealm.class).findAll();
        return wordMapper.mapSimpleWordsRealm(words);

    }

    @Override
    public void deleteWord(@NonNull String id) {
        try {
            realm.executeTransaction(
                    realm1 -> {
                        realm1.where(UserWordRealm.class)
                                .findAll()
                                .where()
                                .equalTo(ID, id)
                                .findFirst()
                                .deleteFromRealm();
                    }
            );
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}