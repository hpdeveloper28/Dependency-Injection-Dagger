package com.hpdeveloper.dependencyinjectiondaggerdemo.di.module;

import android.app.Activity;
import android.content.Context;

import com.hpdeveloper.dependencyinjectiondaggerdemo.di.annotation.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hirenpatel on 27/09/17.
 */

@Module
public class ActivityModule {

    Activity activity;

    public ActivityModule(Activity act){
        activity = act;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity getActivity(){
        return activity;
    }
}
