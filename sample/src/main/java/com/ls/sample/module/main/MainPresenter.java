package com.ls.sample.module.main;

import com.ls.basic.mvp.AbsPresenter;
import com.ls.sample.data.model.Menu;
import com.ls.sample.module.tablayout.TabLayoutActivity;
import com.ls.sample.module.tablayout.frag.TabsToolbarPageFragActivity;
import com.ls.sample.module.toolbar.CollapsingToolbarActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hx on 2017/1/3.
 * core - com.ls.sample.module.quickSidebar
 */
public class MainPresenter extends AbsPresenter implements MainConst.Present {

    private final MainConst.View mView;

    @Inject
    MainPresenter(MainConst.View view) {
        mView = view;
    }

    @Override
    public void getMenus() {
        Observable.just(
                Arrays.asList(
                        new Menu("TabLayout", "TabLayout ViewPager", TabLayoutActivity.class),
                        new Menu("TabsToolbarPageFrag", "TabLayout Toolbar ViewPager Fragment", TabsToolbarPageFragActivity.class),
                        new Menu("CollapsingToolBar", "CollapsingToolBar", CollapsingToolbarActivity.class)
                )
        )
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Menu>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscrebe(d);
                    }

                    @Override
                    public void onNext(List<Menu> value) {
                        mView.addMenus(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
