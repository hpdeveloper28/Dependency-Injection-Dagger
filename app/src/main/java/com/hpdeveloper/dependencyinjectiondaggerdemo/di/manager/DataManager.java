package com.hpdeveloper.dependencyinjectiondaggerdemo.di.manager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by hirenpatel on 27/09/17.
 */

@Singleton
public class DataManager {

    private SharedPreferenceManager sharedPreferencesManager;

    @Inject
    public DataManager(SharedPreferenceManager preferencesManager){
        sharedPreferencesManager = preferencesManager;
    }

    public void storeUserName(String userName){
        sharedPreferencesManager.storeString(SharedPreferenceManager.KEY_USERNAME, userName);
    }

    public String getUserName(){
        return sharedPreferencesManager.getString(SharedPreferenceManager.KEY_USERNAME);
    }
}
