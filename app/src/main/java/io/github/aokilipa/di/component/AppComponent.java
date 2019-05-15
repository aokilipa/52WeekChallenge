package io.github.aokilipa.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.aokilipa.BaseApplication;
import io.github.aokilipa.di.Builder.ActivityBuilder;
import io.github.aokilipa.di.module.AppModule;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 2:10 PM
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
@Singleton
public interface AppComponent{

    /*
     * This builder interface is called from our Application class.
     * This will set our application object to the AppComponent
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     * */
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    /*
     * This is our Application class
     * */
    void inject(BaseApplication application);

}