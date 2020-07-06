package com.allin.commonadapter;

import java.util.List;

/**
 * Description: 数据相关接口
 *
 * @author: legend
 * @date: 2016/4/16 18:07
 */
public interface DataIO<T> {

    /**
     * 设置数据
     *
     * @param datas
     */
    void setDatas(List<T> datas);

    /**
     * 在集合头部添加新的数据集合(唯医终端页需求)
     *
     * @param datas
     */
    void addNewDatas(List<T> datas);

    /**
     * 追加数据(添加在集合尾部)
     *
     * @param datas
     */
    void addMoreDatas(List<T> datas);

    /**
     * 指定位置插入数据
     *
     * @param position
     * @param item
     */
    void addItemAt(int position, T item);

    /**
     * 集合尾部添加一条数据
     *
     * @param item
     */
    void addLastItemData(T item);

    /**
     * 清空数据
     */
    void clean();

    /**
     * 删除指定位置数据
     *
     * @param position
     */
    void removeItemData(int position);

    /**
     * 替换指定位置的数据
     *
     * @param position
     * @param data
     */
    void replaceItemAt(int position, T data);

    /**
     * 替换某个item的数据
     *
     * @param oldData
     * @param newData
     */
    void replaceItem(T oldData, T newData);

    /**
     * 是否包含某条数据
     *
     * @param data
     * @return
     */
    boolean contains(T data);

}
