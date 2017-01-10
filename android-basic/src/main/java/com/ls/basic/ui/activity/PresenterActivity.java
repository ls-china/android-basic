package com.ls.basic.ui.activity;

import com.ls.basic.mvp.AbsPresenter;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.activity
 */
public abstract class PresenterActivity<P extends AbsPresenter> extends BaseActivity<P> {

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

}
