package com.ls.sample.module.tablayout.picture;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ls.basic.ui.view.photoview.PhotoView;
import com.ls.sample.R;
import com.ls.sample.app.SampleApp;
import com.ls.sample.constants.DataConstants;
import com.ls.sample.data.resp.ImageSoPicture;
import com.ls.sample.data.resp.ImageSoResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hx on 2017/2/23.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class PictureFragment extends Fragment implements PictureConstrant.View, SearchView.OnQueryTextListener {
    @Inject
    PicturePresenter mPresenter;

    @Bind(R.id.xrecyclerview)
    protected XRecyclerView mXRecyclerView;
    @Bind(R.id.photoView)
    protected PhotoView mPhotoView;
    private PictureAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPictureComponent.builder()
                .apiComponent(SampleApp.getApiComponent(getContext()))
                .pictureModule(new PictureModule(this))
                .build()
                .inject(this);
        setHasOptionsMenu(true);
        mAdapter = new PictureAdapter(getContext());
//        mAdapter.setOnItemClickListener(this);
        if (null != savedInstanceState) {
            mPresenter.onRestoreSavedInstanceState(savedInstanceState);
            ArrayList<ImageSoPicture> datas = savedInstanceState.getParcelableArrayList(DataConstants.DATA);
            mAdapter.addAll(datas);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, contentView);
        Context context = getContext();
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setAdapter(mAdapter);

        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mXRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh();
            }

            @Override
            public void onLoadMore() {
                mPresenter.onLoadMore();
            }
        });

        if (null == savedInstanceState) {
            mPresenter.onQueryTextSubmit("搞笑");
        }
        return contentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mPresenter.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DataConstants.DATA, new ArrayList<Parcelable>(mAdapter.getDatas()));
    }

    @Override
    public void setPresenter(PictureConstrant.Presenter presenter) {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_frag_picture, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);//在菜单中找到对应控件的item
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mPresenter.onQueryTextSubmit(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onData(boolean isRefresh, ImageSoResponse value) {
        mXRecyclerView.setNoMore(value.end);
        if (isRefresh) {
            mAdapter.clear();
            mXRecyclerView.refreshComplete();
        } else {
            mXRecyclerView.loadMoreComplete();
        }
        mAdapter.addAll(value.list);
    }

    @OnClick(R.id.photoView)
    public void onPhotoViewClick() {
        mPhotoView.setVisibility(View.GONE);
    }

    @Override
    public void callRefresh() {
        mXRecyclerView.scrollToPosition(0);
        mXRecyclerView.refresh();
    }

    //    @Override
//    public void onItemClick(ImageSoPicture item, int position) {
//        boolean isGif = TextUtils.equals("OTHER", item.imgtype);
//        if (isGif) {
//            Glide.with(getContext()).load(item.thumb).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mPhotoView);
//        } else {
//            Glide.with(getContext()).load(item.img).into(mPhotoView);
//        }
//        mPhotoView.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public boolean onItemLongClick(ImageSoPicture imageSoPicture, int position) {
//        return false;
//    }
}
