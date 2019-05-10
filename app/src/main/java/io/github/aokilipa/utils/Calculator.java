package io.github.aokilipa.utils;

import java.util.ArrayList;
import java.util.List;

import io.github.aokilipa.model.Contribution;
import timber.log.Timber;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 11:05 AM
 */
public class Calculator {

    public static void calculateTotal(int deposit, int duration){
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
    }
}
