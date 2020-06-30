package com.allin.refreshandload.loadmore;

import androidx.annotation.ColorInt;
import android.view.View;

/**
 * Description:加载跟多UI展示
 *
 * @author: guoyongping
 * @date: 2016/4/20 16:06
 */
public interface ILoadMoreView {

    /**
     * 显示普通布局
     */
    void showNormal();

    /**
     * 显示已经加载完成，没有更多数据的布局
     */
    void showNoMore();

    /**
     * 显示已经加载完成，没有更多数据的布局
     */
    void showNoMore(String text);

    /**
     * 显示正在加载中的布局
     */
    void showLoading();

    /**
     * 显示加载失败的布局
     */
    void showFail();

    /**
     * 获取footerview
     *
     * @return
     */
    View getFooterView();

    /**
     * 设置加载更多背景颜色
     *
     * @param color 色值
     */
    void setLoadViewBackColor(@ColorInt int color);
}
