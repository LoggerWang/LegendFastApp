package com.legend.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.legend.BuildConfig

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initRouter()
    }

    /**
     * 初始化路由
     */
    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}