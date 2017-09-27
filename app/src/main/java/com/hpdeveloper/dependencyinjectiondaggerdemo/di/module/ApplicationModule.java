package com.hpdeveloper.dependencyinjectiondaggerdemo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.hpdeveloper.dependencyinjectiondaggerdemo.di.annotation.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hirenpatel on 27/09/17.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule (Application app){
        application = app;
    }

    @Provides
    SharedPreferences getSharePreference(){
       return application.getSharedPreferences("SP_MY_APP", Context.MODE_PRIVATE);
    }

    @Provides
    @ApplicationContext
    Context getAppContext(){
        return application.getApplicationContext();
    }
}
