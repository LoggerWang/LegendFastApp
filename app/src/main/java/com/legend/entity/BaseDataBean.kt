package com.legend.entity

/**
 * @author wanglezhi
 * @date   2020/6/29 14:26
 * @discription
 */
data class BaseDataBean<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)