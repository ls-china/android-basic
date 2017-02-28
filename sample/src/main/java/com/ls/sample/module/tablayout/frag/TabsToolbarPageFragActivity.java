package com.ls.sample.module.tablayout.frag;

import android.support.v7.app.ActionBar;

import com.ls.sample.module.tablayout.TabLayoutActivity;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class TabsToolbarPageFragActivity extends TabLayoutActivity {

    @Override
    protected void setupActivityComponent() {

    }

    @Override
    public void initDatas() {
        mAdapter = new TabsFragmentStatePagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void configViews() {
        super.configViews();
        ActionBar actionbar = getSupportActionBar();
        if (null != actionbar) {
            actionbar.setTitle("TabLayout With ViewPager And Fragment Demo");
        }
    }
}
