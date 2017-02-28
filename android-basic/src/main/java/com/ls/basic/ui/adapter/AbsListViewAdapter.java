package com.ls.basic.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ls.basic.ui.viewholder.ViewHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsListViewAdapter<E> extends BaseAdapter implements DataHelper<E> {
    protected final LayoutInflater mLayoutInflater;
    protected final Context mContext;
    protected List<E> datas;
    protected int[] layoutIds;

    public AbsListViewAdapter(Context context) {
        this(context, null, (int[]) null);
    }

    public AbsListViewAdapter(Context context, List<E> datas) {
        this(context, datas, (int[]) null);
    }

    public AbsListViewAdapter(Context context, List<E> datas, int... layoutIds) {
        this.mContext = context;
        this.datas = datas;
        if (null == datas) {
            this.datas = new ArrayList<E>(0);
        }
        mLayoutInflater = LayoutInflater.from(context);
        this.layoutIds = layoutIds;
    }

    public int getCount() {
        return datas.size();
    }

    public long getItemId(int position) {
        return 0;
    }

    public E getItem(int position) {
        if (position >= 0 && position < datas.size()) {
            return datas.get(position);
        }
        return null;
    }

    @Override
    public boolean isEnabled(int position) {
        return position < datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int layoutId = getViewCheckLayoutId(position);
        ViewHelper holder = ViewHelper.getForListView(mContext, convertView, parent, layoutId);
        convert(holder, getItem(position), position);
        return holder.getView();
    }

    private int getViewCheckLayoutId(int position) {
        int layoutId;
        if (layoutIds == null || layoutIds.length == 0) {
            layoutId = getLayoutId(position, datas.get(position));
        } else {
            layoutId = layoutIds[getLayoutIndex(position, datas.get(position))];
        }
        return layoutId;
    }

    /**
     * 若构造函数没有指定layoutIds, 则必须重写该方法
     *
     * @param position
     * @param item
     * @return layoutId
     */
    public int getLayoutId(int position, E item) {
        return 0;
    }

    /**
     * 指定item布局样式在layoutIds的索引。默认为第一个
     *
     * @param position
     * @param item
     * @return
     */
    public int getLayoutIndex(int position, E item) {
        return 0;
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void convert(ViewHelper helper, E item, int position);


    //******************** data helper method ******************//
    @Override
    public boolean addAll(List<E> list) {
        boolean result = datas.addAll(list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean addAll(int position, List<E> list) {
        boolean result = datas.addAll(position, list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public void add(E data) {
        datas.add(data);
        notifyDataSetChanged();
    }

    @Override
    public void add(int position, E data) {
        datas.add(position, data);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public boolean contains(E data) {
        return datas.contains(data);
    }

    @Override
    public E getData(int index) {
        return datas.get(index);
    }

    @Override
    public void modify(E oldData, E newData) {
        modify(datas.indexOf(oldData), newData);
    }

    @Override
    public void modify(int index, E newData) {
        datas.set(index, newData);
        notifyDataSetChanged();
    }

    @Override
    public boolean remove(E data) {
        boolean result = datas.remove(data);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public void remove(int index) {
        datas.remove(index);
        notifyDataSetChanged();
    }
}