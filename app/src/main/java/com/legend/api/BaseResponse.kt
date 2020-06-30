package com.legend.api

import com.legend.base.BaseData
import com.legend.entity.BaseDataBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author wanglezhi
 * @date   2020/6/30 14:35
 * @discription
 */
abstract class BaseResponse<T>():Observer<BaseDataBean<T>> {

    abstract fun onSuccess(data:T ?)

    abstract fun onFail(msg:String ?)

    /**
     * 完成订阅，后执行
     */
    override fun onComplete() {

    }

    /**
     * 开始订阅，先执行
     */
    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: BaseDataBean<T>) {
        if (t.data==null) {
            onFail("失败统一文案")
        }else{
            onSuccess(t.data)
        }
    }

    override fun onError(e: Throwable) {
        onFail(e.message)
    }
}