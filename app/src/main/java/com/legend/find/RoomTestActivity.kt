package com.legend.find

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.legend.ArouterConst
import com.legend.R

@Route(path = ArouterConst.ACTIVITY_ROOM_TEST)
class RoomTestActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test)
    }


}