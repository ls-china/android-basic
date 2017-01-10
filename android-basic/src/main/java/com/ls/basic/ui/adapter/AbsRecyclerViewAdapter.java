package com.ls.basic.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.basic.ui.viewholder.RecylerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx on 2016/3/21.
 */
public abstract class AbsRecyclerViewAdapter<E, VH extends RecylerViewHolder> extends RecyclerView.Adapter<VH> {
    public interface OnItemClickListener<E> {
        void onItemClick(E e, int position);

        boolean onItemLongClick(E e, int position);
    }

    protected final LayoutInflater layoutInflater;
    protected final Context context;
    protected ArrayList<E> datas;
    protected OnItemClickListener onItemClickListener;

    public AbsRecyclerViewAdapter(Context context) {
        datas = new ArrayList<E>(0);
        this.context = context;
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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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
    public int getItemCount() {
        return datas.size();
    }

    public abstract int getContentViewResIdByType(int viewType);

    public abstract void convert(VH holder, E item, int position);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return (VH) new RecylerViewHolder(layoutInflater.inflate(getContentViewResIdByType(viewType), parent, false), context);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        E item = getItem(position);
        holder.getContentView().setOnClickListener(new ViewClick(position, item));
        holder.getContentView().setOnLongClickListener(new ViewClick(position, item));
        convert(holder, item, position);
    }

    private class ViewClick implements View.OnClickListener, View.OnLongClickListener {
        private final int position;
        private final E data;

        private ViewClick(int position, E data) {
            this.position = position;
            this.data = data;
        }

        @Override
        public void onClick(View v) {
            if (null != onItemClickListener) {
                onItemClickListener.onItemClick(data, position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onItemClickListener) {
                return onItemClickListener.onItemLongClick(data, position);
            }
            return false;
        }
    }
}