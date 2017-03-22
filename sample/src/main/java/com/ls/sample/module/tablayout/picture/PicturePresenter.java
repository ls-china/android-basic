package com.ls.sample.module.tablayout.picture;

import android.os.Bundle;

import com.ls.basic.mvp.AbsFragmentPresenter;
import com.ls.sample.constants.DataConstants;
import com.ls.sample.data.Api;
import com.ls.sample.data.resp.ImageSoResponse;

import java.net.URLEncoder;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class PicturePresenter extends AbsFragmentPresenter implements PictureConstrant.Presenter {
    private PictureConstrant.View mView;
    private Api api;
    private int sn;
    private String query;
    private boolean isRefresh;

    @Inject
    PicturePresenter(PictureConstrant.View mView, Api api) {
        this.mView = mView;
        this.api = api;
    }

    @Override
    public void start() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DataConstants.SN, sn);
        outState.putString(DataConstants.QUERY, query);
    }

    @Override
    public void onRestoreSavedInstanceState(Bundle savedInstanceState) {
        super.onRestoreSavedInstanceState(savedInstanceState);
        sn = savedInstanceState.getInt(DataConstants.SN);
        query = savedInstanceState.getString(DataConstants.QUERY);
    }

    @Override
    public void onQueryTextSubmit(String query) {
        this.query = query;
        mView.callRefresh();
//        onRefresh();
    }

    @Override
    public void onRefresh() {
        sn = -50;
        isRefresh = true;
        onLoadMore();
    }

    @Override
    public void onLoadMore() {
        sn += 50;
        api.queryImageSoPicture(getUrl()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerData);
    }

    private String getUrl() {
        String urlquery = URLEncoder.encode(query);
        return String.format(Locale.CHINESE, "http://image.so.com/j?q=%s&src=srp&correct=%s&sn=%d&pn=50", urlquery, urlquery, sn);
    }

    private Observer<ImageSoResponse> observerData = new Observer<ImageSoResponse>() {
        private Disposable d;

        @Override
        public void onSubscribe(Disposable d) {
            this.d = d;
            addSubscrebe(d);
        }

        @Override
        public void onNext(ImageSoResponse value) {
            mView.onData(isRefresh, value);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            onComplete();
        }

        @Override
        public void onComplete() {
            removeSubscrebe(d);
            isRefresh = false;
        }
    };

}
