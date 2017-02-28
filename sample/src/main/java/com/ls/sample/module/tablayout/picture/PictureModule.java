package com.ls.sample.module.tablayout.picture;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

@Module
public class PictureModule {
    private PictureConstrant.View mView;

    public PictureModule(PictureConstrant.View mView) {
        this.mView = mView;
    }

    @Provides
    PictureConstrant.View providePictureConstrantView() {
        return mView;
    }
}
