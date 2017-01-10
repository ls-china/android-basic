package com.ls.sample.module.quickSidebar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ls.basic.ui.adapter.AbsRecyclerViewAdapter;
import com.ls.basic.ui.viewholder.RecylerViewHolder;
import com.ls.sample.R;
import com.ls.sample.model.City;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.security.SecureRandom;

/**
 * Created by hx on 2016/12/26.
 * core - com.ls.basic
 */
public class CityListWithHeadersAdapter extends AbsRecyclerViewAdapter<City, RecylerViewHolder> implements StickyRecyclerHeadersAdapter<RecylerViewHolder> {
    public CityListWithHeadersAdapter(Context context) {
        super(context);
    }

    @Override
    public int getContentViewResIdByType(int viewType) {
        return R.layout.view_item;
    }

    @Override
    public void convert(RecylerViewHolder holder, City item, int position) {
        holder.viewHelper.setText(android.R.id.title, item.getCityName());
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getFirstLetter().charAt(0);
    }

    @Override
    public RecylerViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
        return new RecylerViewHolder(view, context);
    }

    @Override
    public void onBindHeaderViewHolder(RecylerViewHolder holder, int position) {
        ((TextView) holder.itemView).setText(getItem(position).getFirstLetter());
        holder.itemView.setBackgroundColor(getRandomColor());
    }

    private int getRandomColor() {
        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{rgen.nextInt(359), 1, 1});
    }
}
