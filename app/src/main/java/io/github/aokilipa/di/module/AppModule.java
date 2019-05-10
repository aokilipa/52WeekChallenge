package io.github.aokilipa.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.aokilipa.data.local.AppDatabase;
import io.github.aokilipa.data.local.dao.ContributionDao;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 2:11 PM
 */

@Module(includes = ViewModelModule.class)
public class AppModule {
    @Singleton
    @Provides
    AppDatabase provideDb(Application app){
        return Room.databaseBuilder(app,AppDatabase.class,"challenge.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Singleton @Provides
    ContributionDao provideContributionDao(AppDatabase db) {
        return db.contributionDao();
    }


}
