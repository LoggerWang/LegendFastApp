package com.legend.api

import com.legend.BASE_URL_WANANDROID
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author wanglezhi
 * @date   2020/6/30 10:43
 * @discription
 */
class MyRetrofitClient private constructor(){

//    private INSTANCE:Retrofit ?=null
    private object Holder{
        val INSTANCE = MyRetrofitClient()
    }

    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T>getInstance(apiInterface:Class<T>):T{
        var okhttpClient = OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_WANANDROID)
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(apiInterface)
    }
}