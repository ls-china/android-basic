package com.ls.sample.module.quickSidebar;

import android.os.Bundle;

import com.ls.basic.ui.activity.BaseActivity;
import com.ls.basic.ui.view.recylerview.LineSidebarRecylerView;
import com.ls.basic.utils.schedulers.SchedulerProvider;
import com.ls.sample.R;
import com.ls.sample.model.City;

import java.util.List;

import butterknife.Bind;

/**
 * Created by hx on 2016/12/26.
 * core - com.ls.basic
 */
public class QuickSidebarActivity extends BaseActivity<QuickSidebarPresent> implements QuickSidebar.View {
    private CityListWithHeadersAdapter adapter;
    @Bind(R.id.lineSidebarRecylerView)
    LineSidebarRecylerView lineSidebarRecylerView;

    @Override
    protected QuickSidebarPresent initPresenter() {
        return new QuickSidebarPresent(this, SchedulerProvider.getInstance());
    }

    @Override
    protected int getLayout() {
        return R.layout.quick_sidebar_recylerview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CityListWithHeadersAdapter(this);
        lineSidebarRecylerView.setAdapter(adapter);
        lineSidebarRecylerView.setHeaderEnable(true);
        lineSidebarRecylerView.setDividerDecorationEnable(true);
        mPresenter.subscribe();
    }

    @Override
    public void fillData(List<City> data) {
        adapter.clear();
        adapter.addList(data);
        adapter.notifyDataSetChanged();

        int position = 0;
        for (City city : data) {
            String letter = city.getFirstLetter();
            //如果没有这个key则加入并把位置也加入
            this.lineSidebarRecylerView.addLettersPosition(letter, position);
            position++;
        }
    }

    @Override
    public void setPresenter(QuickSidebar.Present presenter) {
        this.mPresenter = (QuickSidebarPresent) presenter;
    }
}
