package com.ls.sample.module.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ls.basic.ui.adapter.AbsViewPagerAdapter;

import java.util.Arrays;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class TabsViewPagerAdapter extends AbsViewPagerAdapter<Integer> {

    public TabsViewPagerAdapter(Context mContext) {
        super(mContext);
        addAll(Arrays.asList(Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Pager Index: " + position;
    }

    @Override
    protected View onCreateView(ViewGroup container, int position, Integer data) {
        return new TextView(mContext);
    }

    @Override
    protected void convert(View contentView, int position, Integer data) {
        TextView textView = (TextView) contentView;
        textView.setBackgroundColor(data);
        textView.setTextColor(Color.WHITE);
        textView.setText(getPageTitle(position));
    }
}
