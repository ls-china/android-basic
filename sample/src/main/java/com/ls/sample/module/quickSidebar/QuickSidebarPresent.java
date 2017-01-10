package com.ls.sample.module.quickSidebar;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ls.basic.mvp.AbsPresenter;
import com.ls.basic.utils.schedulers.BaseSchedulerProvider;
import com.ls.sample.constants.DataConstants;
import com.ls.sample.model.City;

import java.lang.reflect.Type;
import java.util.LinkedList;

/**
 * Created by hx on 2017/1/3.
 * core - com.ls.sample.module.quickSidebar
 */

public class QuickSidebarPresent extends AbsPresenter<QuickSidebar.View> implements QuickSidebar.Present {

    public QuickSidebarPresent(@NonNull QuickSidebar.View mView, @NonNull BaseSchedulerProvider schedulerProvider) {
        super(mView, schedulerProvider);
    }

    @Override
    public void subscribe() {
        getData();
    }

    @Override
    public void getData() {
        Type listType = new TypeToken<LinkedList<City>>() {
        }.getType();
        Gson gson = new Gson();
        LinkedList<City> cities = gson.fromJson(DataConstants.cityDataList, listType);
        mView.fillData(cities);
    }
}
