package com.ls.sample.module.tablayout.picture;

import android.content.Context;
import android.text.TextUtils;

import com.ls.basic.ui.adapter.AbsRecyclerViewAdapter;
import com.ls.basic.ui.viewholder.RecylerViewHolder;
import com.ls.sample.R;
import com.ls.sample.data.resp.ImageSoPicture;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class PictureAdapter extends AbsRecyclerViewAdapter<ImageSoPicture> {
    public PictureAdapter(Context mContext) {
        super(mContext, R.layout.item_image);
    }

    @Override
    public void convert(RecylerViewHolder holder, ImageSoPicture item, int position) {
        boolean isGif = TextUtils.equals("OTHER", item.imgtype);
        if (isGif) {
            holder.viewHelper.setGifUrl(R.id.image, item.thumb);
        } else {
            holder.viewHelper.setImageUrl(R.id.image, item.thumb);
        }
    }
}
