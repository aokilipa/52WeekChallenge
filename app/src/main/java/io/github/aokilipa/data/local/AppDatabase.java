package io.github.aokilipa.data.local;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import io.github.aokilipa.data.local.dao.ContributionDao;
import io.github.aokilipa.model.Contribution;
import io.github.aokilipa.vo.ContributionResults;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 9:21 AM
 */

@Database(
        entities = {Contribution.class, ContributionResults.class},
        version =1,
        exportSchema = false )
public abstract class AppDatabase extends RoomDatabase {

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    public abstract ContributionDao contributionDao();
}
