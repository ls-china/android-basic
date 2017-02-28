package com.ls.basic.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx on 2017/1/17.
 * <br><a href="https://github.com/China-ls">GitHub</a>
 */
public abstract class AbsViewPagerAdapter<E> extends PagerAdapter {
    protected abstract View onCreateView(ViewGroup container, int position, E data);

    protected abstract void convert(View contentView, int position, E data);

    protected List<E> mDatas;
    protected SparseArray<View> mViews;
    protected LayoutInflater mLayoutInflater;
    protected Context mContext;
    private volatile boolean isModifyed;

    public AbsViewPagerAdapter(Context mContext) {
        this(mContext, null);
    }

    public AbsViewPagerAdapter(Context mContext, List<E> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        if (null == this.mDatas) {
            this.mDatas = new ArrayList<E>();
        }
        mViews = new SparseArray<View>(this.mDatas.size());
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public E getItem(int position) {
        if (position < 0 || position >= mDatas.size()) {
            return null;
        }
        return mDatas.get(position);
    }

    public boolean add(E item) {
        boolean result = mDatas.add(item);
        notifyDataSetChanged();
        return result;
    }

    public boolean addAll(List<E> datas) {
        boolean result = mDatas.addAll(datas);
        notifyDataSetChanged();
        return result;
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        E item = getItem(position);
        View view = null;
        if (item instanceof View) {
            view = (View) item;
        } else {
            view = mViews.get(position);
        }
        if (null == view) {
            view = onCreateView(container, position, item);
            mViews.put(position, view);
        }
        convert(view, position, item);
        container.addView(view);//添加页卡
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));//删除页卡
    }
}
