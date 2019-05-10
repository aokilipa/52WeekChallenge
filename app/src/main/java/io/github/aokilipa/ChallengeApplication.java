package io.github.aokilipa;

import android.app.Application;

import timber.log.Timber;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 10:18 AM
 */
public class ChallengeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }

    }

}
