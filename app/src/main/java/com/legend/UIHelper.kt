package com.legend

import com.alibaba.android.arouter.launcher.ARouter

fun goRoomTestActivity(){
    ARouter.getInstance()
        .build(ArouterConst.ACTIVITY_ROOM_TEST)
        .withString("name","")
        .navigation()
}