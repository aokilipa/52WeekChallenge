package io.github.aokilipa.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dagger.android.support.AndroidSupportInjection;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 11:03 AM
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependancyInjection();
        super.onCreate(savedInstanceState);
    }

    private void performDependancyInjection(){
        AndroidSupportInjection.inject(this);
    }

}
