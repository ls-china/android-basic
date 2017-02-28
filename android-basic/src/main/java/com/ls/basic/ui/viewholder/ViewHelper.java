package com.ls.basic.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ViewHelper {
    private View convertView;
    private Context context;
    /**
     * Views indexed with their IDs
     */
    private final SparseArray<View> views;

    public ViewHelper(Context context, View view) {
        this.context = context;
        this.convertView = view;
        views = new SparseArray<View>();
    }

    /**
     * This method is the only entry point to get a BaseAdapterHelper.
     *
     * @param context     The current mContext.
     * @param convertView the convertView arg passed to the getView() method.
     * @param parent      the parent arg passed to the getView() method.
     * @return A BaseAdapterHelper instance.
     */
    public static ViewHelper getForListView(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            ViewHelper helper = new ViewHelper(context, LayoutInflater.from(context).inflate(layoutId, parent, false));
            convertView.setTag(helper);
            return helper;
        }
        return (ViewHelper) convertView.getTag();
    }

    /**
     * Will set the text of a TextView.
     *
     * @param viewId The view id.
     * @param value  The text to put in the text view.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper setText(int viewId, String value) {
        TextView view = retrieveView(viewId);
        view.setText(value);
        return this;
    }

    public ViewHelper setTextColor(int viewId, @ColorInt int color) {
        TextView view = retrieveView(viewId);
        view.setTextColor(color);
        return this;
    }

    public ViewHelper setTextColorRes(int viewId, @ColorRes int colorRes) {
        TextView view = retrieveView(viewId);
        view.setTextColor(context.getResources().getColor(colorRes));
        return this;
    }

    public ViewHelper setBackgroundColor(int viewId, int color) {
        View view = retrieveView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public ViewHelper setBackgroundColorRes(int viewId, int colorRes) {
        View view = retrieveView(viewId);
        view.setBackgroundResource(colorRes);
        return this;
    }

    /**
     * Will set the image of an ImageView from a resource id.
     *
     * @param viewId     The view id.
     * @param imageResId The image resource id.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper setImageResource(int viewId, int imageResId) {
        ImageView view = retrieveView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    /**
     * Will set the image of an ImageView from a drawable.
     *
     * @param viewId   The view id.
     * @param drawable The image drawable.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = retrieveView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public ViewHelper setImageDrawableRes(int viewId, @DrawableRes int drawableRes) {
        Drawable drawable = context.getResources().getDrawable(drawableRes);
        return setImageDrawable(viewId, drawable);
    }

    /**
     * Will download an image from a URL and put it in an ImageView.<br/>
     * It uses Square's Picasso library to download the image asynchronously and put the result into the ImageView.<br/>
     * Picasso manages recycling of views in a ListView.<br/>
     * If you need more control over the Picasso settings, use {ViewHelper#setImageBuilder}.
     *
     * @param viewId   The view id.
     * @param imageUrl The image URL.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper setImageUrl(int viewId, String imageUrl) {
        ImageView view = retrieveView(viewId);
        Glide.with(context).load(imageUrl).into(view);
        return this;
    }

    public ViewHelper setGifUrl(int viewId, String imageUrl) {
        ImageView view = retrieveView(viewId);
        Glide.with(context).load(imageUrl).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
        return this;
    }


    /**
     * Add an action to set the image of an image view. Can be called multiple times.
     */
    public ViewHelper setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = retrieveView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * Add an action to set the alpha of a view. Can be called multiple times.
     * Alpha between 0-1.
     */
    public ViewHelper setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            retrieveView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            retrieveView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper setVisible(int viewId, boolean visible) {
        View view = retrieveView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public ViewHelper setTag(int viewId, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(tag);
        return this;
    }

    public ViewHelper setTag(int viewId, int key, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public ViewHelper setChecked(int viewId, boolean checked) {
        Checkable view = retrieveView(viewId);
        view.setChecked(checked);
        return this;
    }

    public ViewHelper setTypeface(int viewId, Typeface typeface) {
        TextView view = retrieveView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    public ViewHelper setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = retrieveView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public ViewHelper setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * Add links into a TextView.
     *
     * @param viewId The id of the TextView to linkify.
     * @return The ViewHelper for chaining.
     */
    public ViewHelper linkify(int viewId) {
        TextView view = retrieveView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     * Retrieve the convertView
     */
    public View getView() {
        return convertView;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
