package com.app.flashcards;

import static com.app.flashcards.AppConstants.REALM_DB_NAME;
import static com.app.flashcards.AppConstants.REALM_DB_VERSION;

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

        realmBuilder.name(AppConstants.REALM_DB_NAME)
                .schemaVersion(AppConstants.REALM_DB_VERSION)
//              .deleteRealmIfMigrationNeeded()
                .assetFile("words.realm")
                .allowWritesOnUiThread(true)
                .allowQueriesOnUiThread(true);

        RealmConfiguration config = realmBuilder.build();

        Realm.setDefaultConfiguration(config);
    }
}
