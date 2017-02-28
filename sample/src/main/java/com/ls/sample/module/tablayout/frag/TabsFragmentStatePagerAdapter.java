package com.ls.sample.module.tablayout.frag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ls.sample.module.frag.menu.FragBook;
import com.ls.sample.module.frag.menu.FragRadio;
import com.ls.sample.module.frag.menu.FragVideo;
import com.ls.sample.module.tablayout.picture.PictureFragment;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class TabsFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles = {"图片", "电台", "视频", "图书"};

    public TabsFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PictureFragment();
                break;
            case 1:
                fragment = new FragRadio();
                break;
            case 2:
                fragment = new FragVideo();
                break;
            case 3:
                fragment = new FragBook();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
