package com.allin.refreshandload.refresh.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.allin.refreshandload.R;
import com.allin.refreshandload.refresh.PtrFrameLayout;
import com.allin.refreshandload.refresh.PtrUIHandler;
import com.allin.refreshandload.refresh.indicator.PtrIndicator;


/**
 * Description:下拉刷新头部
 *
 * @author: legend
 * @date: 2016/4/3 16:49
 */
public class PullToRefHeader extends RelativeLayout implements PtrUIHandler {

    private static final String TAG = "PullToRefHeader";

    private ImageView arrow;
    private AnimationDrawable animation;


    public PullToRefHeader(Context context) {
        super(context);
        init(context);
    }

    public PullToRefHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public PullToRefHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ptr_pull_to_refresh_header, this);
        arrow = (ImageView) findViewById(R.id.arrow);
        animation = LoadPullAnimRes.getDropDownLoadingAnimDrawable(context);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        arrow.setImageDrawable(animation);
        animation.start();
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        animation.stop();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
            arrow.setImageResource(R.drawable.pull_bg_header);
        }
    }
}
