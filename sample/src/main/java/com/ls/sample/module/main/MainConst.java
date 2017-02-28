package com.ls.sample.module.main;


import com.ls.basic.mvp.BasePresenter;
import com.ls.basic.mvp.BaseView;
import com.ls.sample.data.model.Menu;

import java.util.List;

/**
 * Created by hx on 2017/1/3.
 * core - com.ls.sample.module.quickSidebar
 */

public interface MainConst {
    public interface Present extends BasePresenter {

        void getMenus();

    }

    public interface View extends BaseView<MainConst.Present> {

        void addMenus(List<Menu> menus);

    }
}
