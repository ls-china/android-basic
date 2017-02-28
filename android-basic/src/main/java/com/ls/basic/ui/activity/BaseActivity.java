package com.ls.basic.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.hwangjr.rxbus.RxBus;
import com.ls.basic.R;

import butterknife.ButterKnife;

/**
 * Created by hx on 2016/12/27.
 * core - com.ls.basic.ui.activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mCommonToolbar;

    /**
     * set layout of this activity
     *
     * @return the id of layout
     */
    protected abstract int getLayoutId();

    protected abstract void setupActivityComponent();

    public void initToolBar() {
    }

    public void initDatas() {
    }

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public void configViews() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
        setContentView(getLayoutId());
        transparent19and20();
        ButterKnife.bind(this);
        setupActivityComponent();
        mCommonToolbar = ButterKnife.findById(this, R.id.toolbar);
        if (mCommonToolbar != null) {
            initToolBar();
            setSupportActionBar(mCommonToolbar);
        }
        initDatas();
        configViews();
    }

    protected void transparent19and20() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

}
