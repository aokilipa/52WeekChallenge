package io.github.aokilipa.di.Builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.aokilipa.ChallengeApplication;
import io.github.aokilipa.MainActivity;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 2:13 PM
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity contributeMainActivity();


}
