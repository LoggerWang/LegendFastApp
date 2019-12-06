package com.legend.home

import android.util.Log
import com.legend.R
import com.legend.base.BaseData
import com.legend.base.BaseFragment
import com.legend.entity.WangYiNewsEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class HomeFragment: BaseFragment() {
    companion object{
        const val TAG = "HomeFragment"
    }
    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_home
    }


    init {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.apiopen.top/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiService = retrofit.create(HomeApiService::class.java)
        var call = apiService.getWangYiNews()
        Log.d(TAG,call.toString())
        call.enqueue(object :Callback<BaseData<WangYiNewsEntity>>{
            override fun onFailure(call: Call<BaseData<WangYiNewsEntity>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<BaseData<WangYiNewsEntity>>,
                response: Response<BaseData<WangYiNewsEntity>>
            ) {

                Log.d(TAG,"请求成功")
                var body = response.body()
                if (response.code()==200) {

                    var data = (response.body() as BaseData<WangYiNewsEntity>)
                    var dataList = data.result
                    setData(dataList)
                }else{

                }
//                Log.d(TAG,"第一个题目："+wangYiNewsEntity.title)Response{protocol=http/1.1, code=200, message=, url=https://api.apiopen.top/getWangYiNews}
            }

        })
    }

    private fun setData(dataList: ArrayList<WangYiNewsEntity>?) {

    }

}