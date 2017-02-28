package com.ls.basic.ui.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.frag
 */
public abstract class BaseFragment extends Fragment {
    protected boolean isVisible;

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

}