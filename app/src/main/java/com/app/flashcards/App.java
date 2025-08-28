package com.app.flashcards;

import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRealmDb();
        getToken();
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

    private void getToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        return;
                    }
                    String token = task.getResult();
                    System.out.println("token " + token);
                });
    }
}
