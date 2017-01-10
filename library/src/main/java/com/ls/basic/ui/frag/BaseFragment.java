package com.ls.basic.ui.frag;

import android.support.v4.app.Fragment;

import com.ls.basic.mvp.BasePresenter;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.frag
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected boolean isVisible;
    protected P mPresenter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
    }

    protected void onInvisible() {
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

}