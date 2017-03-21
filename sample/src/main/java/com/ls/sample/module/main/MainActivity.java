package com.ls.sample.module.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ls.basic.ui.activity.BaseActivity;
import com.ls.basic.ui.adapter.AbsRecyclerViewAdapter;
import com.ls.basic.utils.FrameUtil;
import com.ls.basic.utils.KLog;
import com.ls.sample.R;
import com.ls.sample.data.model.Menu;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by hx on 2016/12/26.
 * core - com.ls.basic
 */
public class MainActivity extends BaseActivity implements MainConst.View, AbsRecyclerViewAdapter.OnItemClickListener<Menu> {
    private MenuAdapter adapter;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    protected void setupActivityComponent() {
        // Create the presenter
        DaggerMainComponent.builder()
                .mainPresenterModule(new MainPresenterModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        adapter = new MenuAdapter(this);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void configViews() {
        mCommonToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        mMainPresenter.getMenus();
    }

    @Override
    public void addMenus(List<Menu> menus) {
        adapter.addAll(menus);
    }

    @Override
    public void onItemClick(Menu menu, int position) {
        KLog.d("Adapter", menu);
        FrameUtil.startActivity(this, menu.target);
    }

    @Override
    public boolean onItemLongClick(Menu menu, int position) {
        return false;
    }
}
