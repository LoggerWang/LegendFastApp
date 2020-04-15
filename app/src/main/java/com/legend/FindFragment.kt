package com.legend

import android.view.View
import com.legend.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_find.*

class FindFragment: BaseFragment() {


    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_find
    }

    override fun initData() {

    }

    override fun initView(view: View) {
        btRoom.setOnClickListener {
            goRoomTestActivity()
        }
    }


}