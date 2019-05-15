package io.github.aokilipa;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.github.aokilipa.di.AppInjector;
import timber.log.Timber;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 10:18 AM
 */
public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }

        /*
         * Initialize Dagger Component
         * */
        AppInjector.init(this);

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector(){
        return dispatchingAndroidInjector;
    }

}
