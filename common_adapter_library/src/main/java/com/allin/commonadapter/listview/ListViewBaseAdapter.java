package com.allin.commonadapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.allin.commonadapter.DataIO;
import com.allin.commonadapter.ViewHolder;

import java.util.List;

/**
 * Description:listview的通用适配器
 *
 * @author: legend
 * @date: 2016/4/17 16:53
 */
public abstract class ListViewBaseAdapter<T> extends BaseAdapter implements DataIO<T> {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int mLayoutId;


    /**
     * 构造方法,用于初始化
     *
     * @param context  上下文
     * @param layoutId item的布局id
     * @param datas    数据集
     */
    public ListViewBaseAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutId, position);
        convert(holder, mDatas.get(position), position);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T item, int position);


    @Override
    public void setDatas(List<T> datas) {
        if (datas != null && datas.size() > 0) {
            mDatas = datas;
            notifyDataSetChanged();
        }
    }

    @Override
    public void addNewDatas(List<T> datas) {
        if (datas != null && datas.size() > 0) {
            mDatas.addAll(0, datas);
            notifyDataSetChanged();
        }
    }

    @Override
    public void addMoreDatas(List<T> datas) {
        if (datas != null && datas.size() > 0) {
            mDatas.addAll(datas.size(), datas);
            notifyDataSetChanged();
        }
    }

    @Override
    public void addItemAt(int position, T item) {
        mDatas.add(position, item);
        notifyDataSetChanged();
    }

    @Override
    public void addLastItemData(T item) {
        addItemAt(mDatas.size(), item);
    }

    @Override
    public void clean() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public void removeItemData(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void replaceItemAt(int position, T data) {
        mDatas.set(position, data);
        notifyDataSetChanged();
    }

    @Override
    public void replaceItem(T oldData, T newData) {
        mDatas.set(mDatas.indexOf(oldData), newData);
        notifyDataSetChanged();
    }

    @Override
    public boolean contains(T data) {
        return mDatas.contains(data);
    }
}
