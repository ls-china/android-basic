package com.ls.sample.module.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.ls.basic.ui.activity.BaseActivity;
import com.ls.sample.R;

import butterknife.Bind;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class TabLayoutActivity extends BaseActivity {
    @Bind(R.id.viewpager)
    protected ViewPager mViewPager;
    @Bind(R.id.tablayout)
    protected TabLayout mTabLayout;
    protected PagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_tablayout;
    }

    @Override
    protected void setupActivityComponent() {

    }

    @Override
    public void initDatas() {
        mAdapter = new TabsViewPagerAdapter(this);
    }

    @Override
    public void configViews() {
        mCommonToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ActionBar actionbar = getSupportActionBar();
        if (null != actionbar) {
            actionbar.setTitle("Simple TabLayout With ViewPager Demo");
        }

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
//        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
//        mTabLayout.setTabsFromPagerAdapter(tabsViewPagerAdapter);//给Tabs设置适配器
    }
}
