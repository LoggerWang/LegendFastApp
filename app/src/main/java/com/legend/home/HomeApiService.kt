package com.legend.home

import com.legend.base.BaseData
import com.legend.entity.WangYiNewsEntity
import retrofit2.Call
import retrofit2.http.GET

interface HomeApiService {

    @GET("getWangYiNews")
    fun getWangYiNews(): Call<BaseData<WangYiNewsEntity>>
}