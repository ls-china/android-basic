package com.ls.basic.dagger.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by hx on 2017/2/22.
 * <a href="https://github.com/China-ls">GitHub</a>
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
