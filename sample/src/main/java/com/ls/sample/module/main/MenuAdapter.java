package com.ls.sample.module.main;

import android.content.Context;

import com.ls.basic.ui.adapter.AbsRecyclerViewAdapter;
import com.ls.basic.ui.viewholder.RecylerViewHolder;
import com.ls.sample.R;
import com.ls.sample.data.model.Menu;

/**
 * Created by hx on 2016/12/26.
 * core - com.ls.basic
 */
public class MenuAdapter extends AbsRecyclerViewAdapter<Menu> {

    public MenuAdapter(Context context) {
        super(context, null, R.layout.item_menu);
    }

    @Override
    public void convert(RecylerViewHolder holder, Menu item, int position) {
        holder.viewHelper.setText(android.R.id.title, item.name);
        holder.viewHelper.setText(android.R.id.text1, item.desc);
    }

}
