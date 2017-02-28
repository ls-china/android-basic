package com.ls.sample.module.tablayout.picture;

import com.ls.basic.dagger.annotations.FragmentScope;
import com.ls.sample.data.ApiComponent;

import dagger.Component;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */
@FragmentScope
@Component(dependencies = ApiComponent.class, modules = {PictureModule.class})
public interface PictureComponent {

    void inject(PictureFragment frag);

}
