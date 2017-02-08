package com.ls.basic.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by hx on 2017/1/17.
 * <br><a href="https://github.com/China-ls">GitHub</a>
 */
public class AbsPagerAdapter<E> extends PagerAdapter {
    private List<E> list;

    public AbsPagerAdapter(List<E> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
