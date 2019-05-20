package io.github.aokilipa.vo;

import androidx.room.Entity;
import androidx.room.TypeConverters;

import java.util.List;

import io.github.aokilipa.utils.AppTypeConverter;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 1:29 PM
 */

@Entity(primaryKeys = "id")
@TypeConverters(AppTypeConverter.class)
public class ContributionResults {
    public final int id;
    public final List<Integer> week;


    public ContributionResults(int id, List<Integer> week) {
        this.id = id;
        this.week = week;
    }
}
