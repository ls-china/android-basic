package com.ls.sample.module.toolbar;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ls.basic.ui.activity.BaseActivity;
import com.ls.basic.ui.adapter.AbsRecyclerViewAdapter;
import com.ls.basic.ui.viewholder.RecylerViewHolder;
import com.ls.sample.R;

import java.util.ArrayList;

import butterknife.Bind;

import static com.ls.sample.R.id.recyclerView;

/**
 * Created by hx on 2017/2/28.
 * <a href="https://github.com/China-ls">GitHub</a>
 */

public class CollapsingToolbarActivity extends BaseActivity {
    @Bind(R.id.collapsingToolbarLayout)
    protected CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.image)
    protected ImageView ivImage;
    @Bind(recyclerView)
    protected RecyclerView mRecyclerView;
    private AbsRecyclerViewAdapter<String> mAapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_collapsing;
    }

    @Override
    protected void setupActivityComponent() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initDatas() {
        ArrayList<String> mDatas = new ArrayList<String>(100);
        for (int i = 0; i < 100; i++) {
            mDatas.add("i" + i);
        }
        mAapter = new AbsRecyclerViewAdapter<String>(this, mDatas) {
            @Override
            public int getLayoutId(int viewType) {
                return android.R.layout.simple_list_item_1;
            }

            @Override
            public void convert(RecylerViewHolder holder, String item, int position) {
                holder.viewHelper.setText(android.R.id.text1, item);
            }
        };
    }

    @Override
    public void configViews() {
        collapsingToolbarLayout.setTitle("CollapsingToolbar Demo");
        //通过CollapsingToolbarLayout修改字体颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.GREEN);//设置还没收缩时状态下字体颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        mCommonToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivImage.setImageResource(R.drawable.ym);
        LinearLayoutManager layoutManagerFixed = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManagerFixed);
        mRecyclerView.setAdapter(mAapter);
    }
}
