package com.ls.basic.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the Context dependency to object
 */
@Module
public final class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}