package io.github.aokilipa.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.github.aokilipa.data.local.dao.ContributionDao;
import io.github.aokilipa.model.Contribution;
import io.github.aokilipa.repository.ContributionRepository;
import io.github.aokilipa.utils.AbsentLiveData;
import timber.log.Timber;

public class MainViewModel extends ViewModel {

    private LiveData<List<Contribution>> contributions;

    ContributionRepository repository;

    @Inject
    public MainViewModel(ContributionRepository contributionRepository) {
        this.repository = contributionRepository;

        contributions = repository.loadFromDb();
    }

    public LiveData<List<Contribution>> getContributions() {
        return contributions;
    }

    public void calculateTotal(int deposit, int duration){
        int newDeposit = 0;
        int totalAmount = 0;
        int week;
        List<Contribution> contributions = new ArrayList<>();
        for (week = 1; week<=duration; week++){
            newDeposit += deposit;
            totalAmount +=newDeposit;
            contributions.add(new Contribution(week,newDeposit,totalAmount));

            Timber.d("week: %d, deposit: %d, total: %d", week, newDeposit, totalAmount);
        }

        repository.saveToDb(contributions);
    }




}
