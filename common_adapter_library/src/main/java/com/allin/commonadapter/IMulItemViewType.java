package com.allin.commonadapter;

/**
 * Description:多item支持接口
 *
 * @author: legend
 * @date: 2016/4/17 16:03
 */
public interface IMulItemViewType<T> {

    /**
     * 返回item类型个数
     *
     * @return
     */
    int getViewTypeCount();

    /**
     * 返回不同的type
     *
     * @param position 当前位置的viewholder
     * @param t        当前item的数据
     * @return viewType
     */
    int getItemViewType(int position, T t);

    /**
     * 根据type返回不同item的布局id
     *
     * @param viewType
     * @return
     */
    int getLayoutId(int viewType);
}
