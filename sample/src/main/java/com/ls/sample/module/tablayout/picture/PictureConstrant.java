package com.ls.sample.module.tablayout.picture;

import com.ls.basic.mvp.BasePresenter;
import com.ls.basic.mvp.BaseView;
import com.ls.sample.data.resp.ImageSoResponse;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public interface PictureConstrant {
    public interface Presenter extends BasePresenter {
        void onQueryTextSubmit(String query);

        void onRefresh();

        void onLoadMore();
    }

    public interface View extends BaseView<Presenter> {
        void onData(boolean isRefresh, ImageSoResponse value);

        void callRefresh();
    }

}
