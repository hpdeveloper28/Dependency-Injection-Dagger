package com.hpdeveloper.dependencyinjectiondaggerdemo;

import android.app.Application;
import android.content.Context;

import com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component.ApplicationComponent;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component.DaggerApplicationComponent;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.manager.DataManager;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by hirenpatel on 27/09/17.
 */

public class MyApplication extends Application {

    @Inject
    DataManager dataManager;

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }
}
