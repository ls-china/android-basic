package com.ls.sample.app;

import android.app.Application;
import android.content.Context;

import com.ls.basic.dagger.ApplicationModule;
import com.ls.sample.data.ApiComponent;
import com.ls.sample.data.DaggerApiComponent;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class SampleApp extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationModule applicationModule = new ApplicationModule(getApplicationContext());

        mApiComponent = DaggerApiComponent.builder()
                .applicationModule(applicationModule)
                .build();

    }

    public static ApiComponent getApiComponent(Context context) {
        return ((SampleApp) context.getApplicationContext()).mApiComponent;
    }
}
