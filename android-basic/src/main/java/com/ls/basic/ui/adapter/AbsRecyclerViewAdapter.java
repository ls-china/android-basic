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
public abstract class AbsRecyclerViewAdapter<E> extends RecyclerView.Adapter<RecylerViewHolder> implements DataHelper<E> {
    public interface OnItemClickListener<E> {
        void onItemClick(E e, int position);

        boolean onItemLongClick(E e, int position);
    }

    protected final LayoutInflater layoutInflater;
    protected final Context mContext;
    protected List<E> mDatas;
    protected int[] layoutIds;
    protected OnItemClickListener onItemClickListener;

    public AbsRecyclerViewAdapter(Context mContext) {
        this(mContext, null, (int[]) null);
    }

    public AbsRecyclerViewAdapter(Context mContext, int... layoutIds) {
        this(mContext, null, layoutIds);
    }

    public AbsRecyclerViewAdapter(Context mContext, List<E> mDatas) {
        this(mContext, mDatas, (int[]) null);
    }

    public AbsRecyclerViewAdapter(Context mContext, List<E> mDatas, int... layoutIds) {
        this.mDatas = mDatas;
        if (null == this.mDatas) {
            this.mDatas = new ArrayList<E>(0);
        }
        this.mContext = mContext;
        this.layoutIds = layoutIds;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public void setOnItemClickListener(OnItemClickListener<E> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public E getItem(int position) {
        if (position >= 0 && position < mDatas.size()) {
            return mDatas.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void convert(RecylerViewHolder holder, E item, int position);

    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = getViewCheckLayoutId(viewType);
        return new RecylerViewHolder(layoutInflater.inflate(layoutId, parent, false), mContext);
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {
        E item = getItem(position);
        ViewClick viewClick = new ViewClick(position, item);
        holder.itemView.setOnClickListener(viewClick);
        holder.itemView.setOnLongClickListener(viewClick);
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


    private int getViewCheckLayoutId(int viewType) {
        int layoutId;
        if (layoutIds == null || layoutIds.length == 0) {
            layoutId = getLayoutId(viewType);
        } else {
            layoutId = layoutIds[getLayoutIndex(viewType)];
        }
        return layoutId;
    }

    /**
     * 若构造函数没有指定layoutIds, 则必须重写该方法
     *
     * @param viewType
     * @return layoutId
     */
    public int getLayoutId(int viewType) {
        return 0;
    }

    /**
     * 指定item布局样式在layoutIds的索引。默认为第一个
     *
     * @param viewType
     * @return
     */
    public int getLayoutIndex(int viewType) {
        return 0;
    }

    //*************** ViewHelper Method *********************//


    public List<E> getDatas() {
        return mDatas;
    }

    @Override
    public boolean addAll(List<E> list) {
        boolean result = mDatas.addAll(list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean addAll(int position, List<E> list) {
        boolean result = mDatas.addAll(position, list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public void add(E data) {
        mDatas.add(data);
        notifyItemInserted(mDatas.size() - 1);
    }

    @Override
    public void add(int position, E data) {
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    @Override
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public boolean contains(E data) {
        return mDatas.contains(data);
    }

    @Override
    public E getData(int index) {
        return mDatas.get(index);
    }

    @Override
    public void modify(E oldData, E newData) {
        modify(mDatas.indexOf(oldData), newData);
    }

    @Override
    public void modify(int position, E newData) {
        mDatas.set(position, newData);
        notifyItemChanged(position);
    }

    @Override
    public boolean remove(E data) {
        int position = mDatas.indexOf(data);
        if (position == -1) {
            return false;
        }
        mDatas.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    @Override
    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

}