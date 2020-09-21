package com.legend.entity

/**
 * @author wanglezhi
 * @date   2020/6/29 14:26
 * @discription
 */
data class BaseListDataBean<T>(
    val dataList:List<T>,
    val errorCode: Int,
    val errorMsg: String
)