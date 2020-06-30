package com.allin.refreshandload.refresh.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allin.refreshandload.R;
import com.allin.refreshandload.refresh.PtrFrameLayout;
import com.allin.refreshandload.refresh.PtrUIHandler;
import com.allin.refreshandload.refresh.indicator.PtrIndicator;

/**
 * Description:唯医3.0下拉加载header
 *
 * @author: guoyongping
 * @date: 16/8/1 13:54
 */

public class PullToRefHeaderNew extends RelativeLayout implements PtrUIHandler {

    private TextView mTitleTextView;
    private CustomerCircleView mRotateView;

    public PullToRefHeaderNew(Context context) {
        super(context);
        initViews(null);
    }

    public PullToRefHeaderNew(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(attrs);
    }

    public PullToRefHeaderNew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs);
    }


    protected void initViews(AttributeSet attrs) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.ptr_pull_header_new, this);
        mRotateView = header.findViewById(R.id.ptr_classic_header_rotate_header_view);
        mTitleTextView = header.findViewById(R.id.ptr_classic_header_rotate_view_header_title);
    }

    private void hideRotateView() {
        mRotateView.clearAnimation();
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        hideRotateView();
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mRotateView.setVisibility(VISIBLE);
        mTitleTextView.setVisibility(VISIBLE);
        mTitleTextView.setText("下拉即可刷新...");
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        hideRotateView();
        mTitleTextView.setVisibility(VISIBLE);
        mTitleTextView.setText(R.string.cube_ptr_refreshing);
        startLoadingAnimation();
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        hideRotateView();
        mTitleTextView.setVisibility(INVISIBLE);
        mTitleTextView.setText(getResources().getString(R.string.cube_ptr_refresh_complete));
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        final int mOffsetToRefresh = frame.getOffsetToRefresh();
        int currentPos = ptrIndicator.getCurrentPosY();
        final int lastPos = ptrIndicator.getLastPosY();

        if (mRotateView != null) {
            if (currentPos <= mOffsetToRefresh) {
                if (mOffsetToRefresh != 0) {
                    int x = 350 * currentPos / mOffsetToRefresh;
                    if (x != 0) {
                        mRotateView.start(x);
                        mRotateView.invalidate();
                    }
                }
            }
        }

        if (currentPos < mOffsetToRefresh && lastPos >= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                crossRotateLineFromBottomUnderTouch();
            }
        } else if (currentPos > mOffsetToRefresh && lastPos <= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                crossRotateLineFromTopUnderTouch();
            }
        }
    }

    private void crossRotateLineFromTopUnderTouch() {
        mTitleTextView.setVisibility(VISIBLE);
        mTitleTextView.setText("释放即可刷新...");
    }

    private void crossRotateLineFromBottomUnderTouch() {
        mTitleTextView.setVisibility(VISIBLE);
        mTitleTextView.setText("下拉即可刷新...");
    }

    /**
     * 开启旋转动画
     */
    private void startLoadingAnimation(){
        RotateAnimation rotate  = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin);
        //设置动画持续周期
        rotate.setDuration(400);
        //设置重复次数
        rotate.setRepeatCount(-1);
        //动画执行完后是否停留在执行完的状态
        rotate.setFillAfter(true);
        mRotateView.startAnimation(rotate);
    }

    @Override
    protected void onDetachedFromWindow() {
        hideRotateView();
        super.onDetachedFromWindow();
    }
}
