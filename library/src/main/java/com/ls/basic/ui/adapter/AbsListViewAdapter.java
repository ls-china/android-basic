package com.ls.basic.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ls.basic.ui.viewholder.ViewHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsListViewAdapter<E> extends BaseAdapter {
    protected final LayoutInflater layoutInflater;
    protected final Context context;
    protected ArrayList<E> datas;

    public AbsListViewAdapter(Context context) {
        this(context, null);
    }

    public AbsListViewAdapter(Context context, ArrayList<E> datas) {
        this.context = context;
        this.datas = datas;
        if (null == datas) {
            datas = new ArrayList<E>(0);
        }
        layoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<E> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        datas.addAll(list);
    }

    @SafeVarargs
    public final void add(E... items) {
        if (null == items) {
            return;
        }
        for (E e : items) {
            addSingle(e);
        }
    }

    public void addSingle(E item) {
        if (null == item) {
            return;
        }
        datas.add(item);
    }

    public int getCount() {
        return datas.size();
    }

    public long getItemId(int position) {
        return 0;
    }

    public void clear() {
        datas.clear();
    }

    public void remove(int index) {
        datas.remove(index);
    }

    public void remove(E e) {
        datas.remove(e);
    }

    public E getItem(int position) {
        return datas.get(position);
    }

    @Override
    public boolean isEnabled(int position) {
        return position < datas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHelper holder = ViewHelper.getForListView(context, convertView, parent, getLayoutResId());
        convert(holder, getItem(position), position);
        return holder.getView();
    }

    protected abstract int getLayoutResId();

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    protected abstract void convert(ViewHelper helper, E item, int position);

}