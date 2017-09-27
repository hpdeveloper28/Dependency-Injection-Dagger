package com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component;

import com.hpdeveloper.dependencyinjectiondaggerdemo.MyApplication;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.manager.DataManager;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hirenpatel on 27/09/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    DataManager getDataManager();

}
