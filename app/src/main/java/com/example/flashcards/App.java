package com.example.flashcards;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRealmDb();
    }

    private void initRealmDb() {
        Realm.init(this);

        RealmConfiguration.Builder realmBuilder = new RealmConfiguration.Builder();

        realmBuilder.name("words.realm")
                .allowWritesOnUiThread(true)
                .allowQueriesOnUiThread(true);

        RealmConfiguration config = realmBuilder.build();

        Realm.setDefaultConfiguration(config);
    }
}
