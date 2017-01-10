package com.ls.basic.ui.view.recylerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;
import com.bigkoo.quicksidebar.listener.OnQuickSideBarTouchListener;
import com.ls.basic.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by hx on 2016/12/26.
 * core - com.ls.basic.ui.view.recylerview
 * <p>
 * Example
 * 1、xml
 */
public class LineSidebarRecylerView extends RelativeLayout implements OnQuickSideBarTouchListener {
    private RecyclerView recyclerView;
    private QuickSideBarView quickSideBarView;
    private QuickSideBarTipsView quickSideBarTipsView;
    private HashMap<String, Integer> lettersPositionMap = new HashMap<String, Integer>();
    private ArrayList<String> lettersPositionKeys = new ArrayList<String>();
    private DividerDecoration dividerDecoration;
    private boolean dividerDecorationEnable;
    private StickyRecyclerHeadersDecoration headersDecor;
    private boolean headerEnable;

    private Context context;

    public LineSidebarRecylerView(Context context) {
        super(context);
        init(context);
    }

    public LineSidebarRecylerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LineSidebarRecylerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LineSidebarRecylerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
//        ViewGroup contentView = (ViewGroup)
        LayoutInflater.from(context).inflate(R.layout.view_line_sidebar_recylerview, this, true);
        recyclerView = (RecyclerView) findViewById(R.id.core_recyleview_rv);
        quickSideBarView = (QuickSideBarView) findViewById(R.id.core_recyleview_sidebar);
        quickSideBarTipsView = (QuickSideBarTipsView) findViewById(R.id.core_recyleview_sidebar_tips);
        //设置监听
        quickSideBarView.setOnQuickSideBarTouchListener(this);
        //设置列表数据和浮动header
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setDividerDecorationEnable(boolean enable) {
        if (enable) {
            if (null == dividerDecoration) {
                dividerDecoration = new DividerDecoration(context);
            }
            recyclerView.addItemDecoration(dividerDecoration);
            dividerDecorationEnable = true;
        } else {
            if (dividerDecorationEnable && null != dividerDecoration) {
                recyclerView.removeItemDecoration(dividerDecoration);
            }
            dividerDecorationEnable = false;
        }
    }

    public boolean isDividerDecorationEnable() {
        return dividerDecorationEnable;
    }

    public DividerDecoration getDividerDecoration() {
        return dividerDecoration;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.recyclerView.setAdapter(adapter);
        ensureHeader();
    }

    private void ensureHeader() {
        if (headerEnable) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (null == adapter) {
                return;
            }
            if (!(adapter instanceof StickyRecyclerHeadersAdapter)) {
                throw new IllegalArgumentException("If enable sticky header, the recyclerview's adapter should extends from StickyRecyclerHeadersAdapter.");
            }
            if (null != headersDecor) {
                recyclerView.removeItemDecoration(headersDecor);
            }
            headersDecor = new StickyRecyclerHeadersDecoration((StickyRecyclerHeadersAdapter) adapter);
            recyclerView.addItemDecoration(headersDecor);
        }
    }

    public void setHeaderEnable(boolean enable) {
        if (this.headerEnable == enable) {
            return;
        }
        this.headerEnable = enable;
        ensureHeader();
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void clearLettersPosition() {
        this.lettersPositionMap.clear();
        this.lettersPositionKeys.clear();
        this.quickSideBarView.setLetters(this.lettersPositionKeys);
    }

    public void addLettersPosition(String letter, Integer position) {
        this.addLettersPosition(letter, position, false);
    }

    public void addLettersPosition(String letter, Integer position, boolean ignoreContains) {
        boolean shouldAdd = ignoreContains || !lettersPositionMap.containsKey(letter);
        if (shouldAdd) {
            lettersPositionMap.put(letter, position);
            lettersPositionKeys.add(letter);
        }
        this.quickSideBarView.setLetters(lettersPositionKeys);
    }

    public void setLettersPositionMap(HashMap<String, Integer> lettersPositionMap) {
        if (null == lettersPositionMap) {
            return;
        }
        this.lettersPositionMap = lettersPositionMap;
        ArrayList<String> keys = new ArrayList<String>(lettersPositionMap.keySet());
        Collections.sort(keys);
        this.quickSideBarView.setLetters(keys);
    }

    @Override
    public void onLetterChanged(String letter, int position, float y) {
        quickSideBarTipsView.setText(letter, position, y);
        //有此key则获取位置并滚动到该位置
        if (lettersPositionMap.containsKey(letter)) {
            recyclerView.scrollToPosition(lettersPositionMap.get(letter));
        }
    }

    @Override
    public void onLetterTouching(boolean touching) {
        //可以自己加入动画效果渐显渐隐
        quickSideBarTipsView.setVisibility(touching ? View.VISIBLE : View.INVISIBLE);
    }
}
