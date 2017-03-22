package com.ls.sample.module.tablayout.picture;

import com.ls.basic.mvp.FragmentPresenter;
import com.ls.basic.mvp.FragmentView;
import com.ls.sample.data.resp.ImageSoResponse;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public interface PictureConstrant {
    public interface Presenter extends FragmentPresenter {
        void onQueryTextSubmit(String query);

        void onRefresh();

        void onLoadMore();
    }

    public interface View extends FragmentView<Presenter> {
        void onData(boolean isRefresh, ImageSoResponse value);

        void callRefresh();
    }

}
