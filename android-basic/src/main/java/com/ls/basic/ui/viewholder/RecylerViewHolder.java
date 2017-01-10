package com.ls.basic.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hx on 2016/3/21.
 */
public class RecylerViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    public final ViewHelper viewHelper;

    public RecylerViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        viewHelper = new ViewHelper(context, itemView);
    }

    public View getContentView() {
        return itemView;
    }

}
