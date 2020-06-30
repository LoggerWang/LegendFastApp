package com.legend.home

import android.util.Log
import android.view.View
import com.legend.R
import com.legend.api.ArticleService
import com.legend.api.BaseResponse
import com.legend.api.MyRetrofitClient
import com.legend.base.BaseData
import com.legend.base.BaseFragment
import com.legend.entity.ArticleBean
import com.legend.entity.BaseDataBean
import com.legend.entity.WangYiNewsEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.*

class HomeFragment: BaseFragment() {
    companion object{
        const val TAG = "HomeFragment"
    }
    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
         MyRetrofitClient.instance.getInstance(ArticleService::class.java).getArticleList()
             .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseResponse<ArticleBean>(){
                override fun onSuccess(data: ArticleBean?) {
                    println("======="+data.toString())
                    setArticleData(data)
                }

                override fun onFail(msg: String?) {
                }
            })
    }

    private fun setArticleData(data: ArticleBean?) {

    }

    override fun initView(view: View) {
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