package com.allin.refreshandload.loadmore;

/**
 * Description:加载更多模式
 *
 * @author: legend
 * @date: 2016/4/20 16:05
 */
public enum LoadMoreMode {
    /**
     * 点击加载更多
     */
    CLICK,
    /**
     * 滑动到底部加载跟多
     */
    SCROLL;

    static LoadMoreMode mapIntToValue(int modeInt) {
        switch (modeInt) {
            case 0x0:
            default:
                return CLICK;
            case 0x1:
                return SCROLL;
        }
    }
}
