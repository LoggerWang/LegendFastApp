package com.allin.commonadapter.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.allin.commonadapter.IMulItemViewType;
import com.allin.commonadapter.ViewHolder;

import java.util.List;

/**
 * Description:多item的ListView适配器
 *
 * @author: legend
 * @date: 2016/4/17 17:19
 */
public abstract class MultiItemListViewAdapter<T> extends ListViewBaseAdapter<T> {

    protected IMulItemViewType<T> mTIMulItemViewType;

    public MultiItemListViewAdapter(Context context, List<T> datas, IMulItemViewType<T> multiItemTypeSupport) {
        super(context, -1, datas);
        mTIMulItemViewType = multiItemTypeSupport;
        if (mTIMulItemViewType == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }


    @Override
    public int getItemViewType(int position) {
        if (mTIMulItemViewType != null)
            return mTIMulItemViewType.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        if (mTIMulItemViewType != null)
            return mTIMulItemViewType.getViewTypeCount();
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mTIMulItemViewType == null) {
            return super.getView(position, convertView, parent);
        }
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mTIMulItemViewType.getLayoutId(getItemViewType(position)), position);
        convert(holder, mDatas.get(position), position);
        return holder.getConvertView();
    }
}
