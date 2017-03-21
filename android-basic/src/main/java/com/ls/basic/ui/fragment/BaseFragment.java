package com.ls.basic.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.ls.basic.mvp.FragmentPresenter;
import com.ls.basic.mvp.FragmentView;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.frag
 */
public abstract class BaseFragment<P extends FragmentPresenter> extends Fragment implements FragmentView<P> {
    protected boolean isVisible;
    protected P mPresenter;

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

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
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (null != savedInstanceState) {
            mPresenter.onRestoreSavedInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

}