package io.github.aokilipa.di.Builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.aokilipa.ui.main.MainFragment;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 2:15 PM
 */
@Module
public abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();
}
