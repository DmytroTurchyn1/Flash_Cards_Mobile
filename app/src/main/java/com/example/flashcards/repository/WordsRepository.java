package com.example.flashcards.repository;

import androidx.annotation.NonNull;
import com.example.flashcards.model.data.IrregularVerbRealm;
import com.example.flashcards.model.data.SimpleWordsRealm;
import com.example.flashcards.model.data.WordMapper;
import com.example.flashcards.model.data.UserWordRealm;
import com.example.flashcards.model.local.IrregularVerb;
import com.example.flashcards.model.local.UserWord;
import com.example.flashcards.model.local.Word;
import com.example.flashcards.model.local.SimpleWord;
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
        saveSimpleWords(new SimpleWord("Бути","Be"));
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
    public void deleteWord(String id) {
        realm.executeTransaction(
                realm1 -> {
                    //realm1.(UserWordRealm.class);

                    //RealmResults result = realm1.where(UserWordRealm.class).equalTo("id",id).findAll();
                       // result.deleteFromRealm(Integer.parseInt(id));

                }
        );
    }
}