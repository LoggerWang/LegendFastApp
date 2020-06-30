package com.allin.refreshandload.refresh.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.allin.refreshandload.refresh.FixPrtFrameLayout;


/**
 * Description:下拉刷新控件
 * 使用方法:使用该控件包裹需要下拉的子控件,可以是任意view
 *
 * @author: guoyongping
 * @date: 2016/4/3 16:47
 */
public class PullToRefFrameLayout extends FixPrtFrameLayout {

    public PullToRefFrameLayout(Context context) {
        super(context);
        initView();
    }

    public PullToRefFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        PullToRefHeaderNew header = new PullToRefHeaderNew(getContext());
        setHeaderView(header);
        addPtrUIHandler(header);
        this.setKeepHeaderWhenRefresh(true);
        this.setPullToRefresh(false);
        this.setDurationToClose(200);
        this.setDurationToCloseHeader(300);
        this.setResistance(1.7f);
        this.setRatioOfHeaderHeightToRefresh(1.01f);
        this.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.setOffsetToKeepHeaderWhileLoading(200);
        this.setMaxPullOffset(360);
    }


    /**
     * 设置最大下拉距离(不设置默认不限制下拉距离)
     *
     * @param offset 距离(像素)
     */
    public void setMaxPullOffset(int offset) {
        this.maxPullOffset = offset;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onRefreshComplete();
    }
}
