package com.hpdeveloper.dependencyinjectiondaggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component.ActivityComponent;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.Component.DaggerActivityComponent;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.manager.DataManager;
import com.hpdeveloper.dependencyinjectiondaggerdemo.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    @BindView(R.id.edtName)
    AppCompatEditText edtName;

    @BindView(R.id.txtName)
    AppCompatTextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);

    }

    private ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MyApplication.get(this).getApplicationComponent())
                    .build();
        }

        return activityComponent;
    }

    public void onStoreValue(View view) {
        dataManager.storeUserName(edtName.getText().toString().trim());
    }

    public void onGetValue(View view) {
        txtName.setText(dataManager.getUserName());
    }
}
