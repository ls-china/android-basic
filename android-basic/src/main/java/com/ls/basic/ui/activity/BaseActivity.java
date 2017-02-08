package com.ls.basic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hwangjr.rxbus.RxBus;
import com.ls.basic.mvp.AbsPresenter;

import butterknife.ButterKnife;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.activity
 */
public abstract class BaseActivity<P extends AbsPresenter> extends AppCompatActivity {
    protected P mPresenter;

    protected void initView() {
    }

    protected abstract P initPresenter();

    /**
     * set layout of this activity
     *
     * @return the id of layout
     */
    protected abstract int getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        mPresenter = initPresenter();
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

}
