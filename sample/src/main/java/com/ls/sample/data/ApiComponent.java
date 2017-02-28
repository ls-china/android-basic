package com.ls.sample.data;


import com.ls.basic.dagger.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hx on 2017/2/22.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

@Singleton
@Component(modules = {ApiModule.class, ApplicationModule.class})
public interface ApiComponent {

    Api getApi();

}
