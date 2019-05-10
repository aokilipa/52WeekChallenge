package io.github.aokilipa.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.github.aokilipa.AppExecutors;
import io.github.aokilipa.data.local.dao.ContributionDao;
import io.github.aokilipa.model.Contribution;
import io.github.aokilipa.utils.AbsentLiveData;
import io.github.aokilipa.vo.ContributionResults;
import timber.log.Timber;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 2:00 PM
 */
@Singleton
public class ContributionRepository {


    AppExecutors executor;
    final ContributionDao dao;

    @Inject
    public ContributionRepository(AppExecutors executor, ContributionDao dao) {
        this.executor = executor;
        this.dao = dao;
    }



    public void saveToDb(List<Contribution> contributions) {

        List<Integer> week_id = new ArrayList<>();
        executor.diskIO().execute(() -> {
            for (Contribution c: contributions) {
                week_id.add(c.week);
            }

            ContributionResults result = new ContributionResults(1,week_id);
            try {
                dao.insertContribution(contributions);
                dao.insert(result);
            }catch (Exception e){
                Timber.d("Error: %s", e.toString());
            }
        });


    }

    public LiveData<List<Contribution>> loadFromDb() {

        return Transformations.switchMap(dao.search(1), input -> {
            if (input == null) {
                return AbsentLiveData.create();
            } else {
                return dao.selectAll(input.week);
            }
        });
    }

}
