package com.ls.sample.data.model;

import android.app.Activity;

import java.io.Serializable;

/**
 * Created by hx on 2017/2/22.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class Menu implements Serializable {
    public String name;
    public String desc;
    public Class<? extends Activity> target;

    public Menu(String name, Class<? extends Activity> target) {
        this(name, "", target);
    }

    public Menu(String name, String desc, Class target) {
        this.name = name;
        this.desc = desc;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                "desc='" + desc + '\'' +
                ", target=" + target +
                '}';
    }
}
