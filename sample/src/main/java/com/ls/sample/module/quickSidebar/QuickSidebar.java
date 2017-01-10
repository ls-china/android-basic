package com.ls.sample.module.quickSidebar;

import com.ls.basic.mvp.BasePresenter;
import com.ls.basic.mvp.BaseView;
import com.ls.sample.model.City;

import java.util.List;

/**
 * Created by hx on 2017/1/3.
 * core - com.ls.sample.module.quickSidebar
 */

public interface QuickSidebar {
    public interface Present extends BasePresenter {
        void getData();
    }

    public interface View extends BaseView<QuickSidebar.Present> {
        void fillData(List<City> data);
    }
}
