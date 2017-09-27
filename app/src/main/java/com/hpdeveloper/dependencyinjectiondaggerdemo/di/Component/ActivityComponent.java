package com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component;

import com.hpdeveloper.dependencyinjectiondaggerdemo.MainActivity;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.annotation.PerActivity;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by hirenpatel on 27/09/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
