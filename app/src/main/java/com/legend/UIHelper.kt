package com.legend

import com.alibaba.android.arouter.launcher.ARouter

fun goRoomTestActivity(){
    ARouter.getInstance()
        .build(ArouterConst.ACTIVITY_ROOM_TEST)
        .withString("name","")
        .navigation()
}


fun goButterKnifeJavaActivity(){
    ARouter.getInstance()
        .build(ArouterConst.ACTIVITY_BUTTERKNIFE_JAVA)
        .withString("name","")
        .navigation()
}