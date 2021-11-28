package com.example.flashcards.repository;

public class WordsRepository implements IWordsRepository {
    private static IWordsRepository repository;

    private WordsRepository() {
        // TODO Consider initializing RealmDB here in constructor
    }

    public static IWordsRepository getInstance() {
        if (repository == null) {
            repository = new WordsRepository();
        }
        return repository;
    }
}
