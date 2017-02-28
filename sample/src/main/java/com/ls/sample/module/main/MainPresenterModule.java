package com.ls.sample.module.main;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link MainPresenter}.
 */
@Module
public class MainPresenterModule {

    private final MainConst.View mView;

    public MainPresenterModule(MainConst.View view) {
        mView = view;
    }

    @Provides
    MainConst.View provideMainConstView() {
        return mView;
    }

}