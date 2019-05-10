package io.github.aokilipa.utils;

import androidx.lifecycle.LiveData;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 1:27 PM
 */
public class AbsentLiveData extends LiveData {
    private AbsentLiveData() {
        postValue(null);
    }
    public static <T> LiveData<T> create() {
        //noinspection unchecked
        return new AbsentLiveData();
    }
}
