package com.hpdeveloper.dependencyinjectiondaggerdemo.di.manager;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by hirenpatel on 27/09/17.
 */

@Singleton
public class SharedPreferenceManager {

    static String KEY_USERNAME = "sp_username";
    SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferenceManager (SharedPreferences preferences){
        sharedPreferences = preferences;
    }

    public void storeString(String key, String value){
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key){
        return sharedPreferences.getString(key, "");
    }
}
