package com.ls.sample.module.main;

import com.ls.basic.dagger.annotations.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = MainPresenterModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
