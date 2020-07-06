package com.allin.commonadapter.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.allin.commonadapter.DataIO;
import com.allin.commonadapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:单个item的RecyclerView通用adapter适配器
 */
public abstract class RecyclerViewBaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements DataIO<T> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas = new ArrayList<>();
    protected LayoutInflater mInflater;

    public RecyclerViewBaseAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    /**
     * 构造方法,用于初始化
     *
     * @param context  上下文
     * @param layoutId item的布局id
     * @param datas    数据集
     */
    public RecyclerViewBaseAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.get(mContext, null, parent, mLayoutId, -1);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    /**
     * 是否禁用
     *
     * @param viewType
     * @return
     */
    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * 数据与view绑定
     *
     * @param holder
     * @param item
     */
    public abstract void convert(ViewHolder holder, T item, int position);


    @Override
    public void setDatas(List<T> datas) {
        if (datas != null && datas.size() > 0) {
            mDatas = datas;
            notifyDataSetChanged();
        }
    }

    /**
     * 获取集合数据
     *
     * @return 返回list
     */
    public List<T> getmDatas() {
        if (mDatas != null && mDatas.size() > 0) {
            return mDatas;
        }
        return null;
    }

    /**
     * 在集合最前面添加新的数据集合(唯医终端页需求)
     *
     * @param datas
     */
    @Override
    public void addNewDatas(List<T> datas) {
        if (datas != null && datas.size() > 0) {
            mDatas.addAll(0, datas);
            notifyItemRangeInserted(0, datas.size());
        }
    }

    /**
     * 指定位置插入数据
     *
     * @param position
     * @param item
     */
    @Override
    public void addItemAt(int position, T item) {
        mDatas.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * 数据最后面追加新数据
     *
     * @param datas
     */
    @Override
    public void addMoreDatas(List<T> datas) {
        int oldSize = mDatas.size();
        if (datas != null && datas.size() > 0) {
            mDatas.addAll(mDatas.size(), datas);
            notifyItemRangeInserted(oldSize, datas.size());
        }
    }


    /**
     * 列表最后面添加一条数据
     *
     * @param item
     */
    @Override
    public void addLastItemData(T item) {
        addItemAt(mDatas.size(), item);
    }

    /**
     * 清空列表
     */
    @Override
    public void clean() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    /**
     * 删除指定位置的数据
     *
     * @param position
     */
    @Override
    public void removeItemData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDatas.size() - position);
    }

    /**
     * 替换指定位置数据
     *
     * @param position
     * @param data
     */
    @Override
    public void replaceItemAt(int position, T data) {
        mDatas.set(position, data);
        notifyItemChanged(position);
    }

    /**
     * 替换某个条目数据
     *
     * @param oldData
     * @param newData
     */
    @Override
    public void replaceItem(T oldData, T newData) {
        replaceItemAt(mDatas.indexOf(oldData), newData);
    }

    /**
     * 是否含有某条数据
     *
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) {
        return mDatas.contains(data);
    }
}
