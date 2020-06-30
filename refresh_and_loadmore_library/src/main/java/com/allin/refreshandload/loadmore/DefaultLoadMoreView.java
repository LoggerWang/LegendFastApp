package com.allin.refreshandload.loadmore;

import android.content.Context;
import androidx.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allin.refreshandload.R;

/**
 * Description:默认加载更多footer
 *
 * @author: guoyongping
 * @date: 2016/4/20 13:57
 */
public class DefaultLoadMoreView extends RelativeLayout implements ILoadMoreView {

    private LinearLayout linearLayout;
    private TextView mTvMessage;
    private TextView mTvNoMoreMsg;
    private ProgressBar mPbLoading;

    public DefaultLoadMoreView(Context context) {
        super(context);
        init(context);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.loading_view_final_footer_default, this);
        linearLayout = (LinearLayout) findViewById(R.id.ll_load_view_content);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        mTvMessage = (TextView) findViewById(R.id.tv_loading_msg);
        mTvNoMoreMsg = (TextView) findViewById(R.id.tv_no_more_msg);
    }

    @Override
    public void showNormal() {
        mTvNoMoreMsg.setVisibility(View.GONE);
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setVisibility(View.VISIBLE);
        mTvMessage.setText(R.string.loading_view_click_loading_more);
    }

    @Override
    public void showNoMore() {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setVisibility(View.GONE);
        mTvNoMoreMsg.setVisibility(View.VISIBLE);
        mTvNoMoreMsg.setText(R.string.loading_view_no_more);
    }

    @Override
    public void showNoMore(String text) {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setVisibility(View.GONE);
        mTvNoMoreMsg.setVisibility(View.VISIBLE);
        mTvNoMoreMsg.setText(text);
    }

    @Override
    public void showLoading() {
        mTvNoMoreMsg.setVisibility(View.GONE);
        mPbLoading.setVisibility(View.VISIBLE);
        mTvMessage.setVisibility(View.VISIBLE);
        mTvMessage.setText(R.string.loading_view_loading);
    }

    @Override
    public void showFail() {
        mPbLoading.setVisibility(View.GONE);
        mTvMessage.setVisibility(View.VISIBLE);
        mTvMessage.setText(R.string.loading_view_net_error);
    }

    @Override
    public void setLoadViewBackColor(@ColorInt int color){
        linearLayout.setBackgroundColor(color);
    }

    @Override
    public View getFooterView() {
        return this;
    }



}
