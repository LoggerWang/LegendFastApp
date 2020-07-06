package com.allin.commonadapter.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.allin.commonadapter.IMulItemViewType;
import com.allin.commonadapter.ViewHolder;

import java.util.List;

/**
 * Description:多个item的RecycleView适配器
 *
 * @author: legend
 * @date: 2016/4/17 16:16
 */
public abstract class MultiItemRecycleViewAdapter<T> extends RecyclerViewBaseAdapter<T> {

    protected IMulItemViewType<T> mTIMulItemViewType;

    /**
     * 构造方法
     *
     * @param context
     * @param datas
     * @param iMulItemViewType
     */
    public MultiItemRecycleViewAdapter(Context context, List<T> datas, IMulItemViewType<T> iMulItemViewType) {
        super(context, -1, datas);
        mTIMulItemViewType = iMulItemViewType;
        if (mTIMulItemViewType == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mTIMulItemViewType == null)
            return super.onCreateViewHolder(parent, viewType);

        int layoutId = mTIMulItemViewType.getLayoutId(viewType);
        ViewHolder holder = ViewHolder.get(mContext, null, parent, layoutId, -1);
        return holder;
    }


    @Override
    public int getItemViewType(int position) {
        if (mTIMulItemViewType != null) {
            return mTIMulItemViewType.getItemViewType(position, mDatas.get(position));
        }

        return super.getItemViewType(position);
    }
}
