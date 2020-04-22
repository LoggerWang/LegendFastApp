package com.legend.mine

import android.view.View
import com.legend.R
import com.legend.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

class Minefragment: BaseFragment() {


    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData() {

    }

    override fun initView(view: View) {
        tbInvoke.setOnClickListener {
            invokeTest()
        }
    }

    private fun invokeTest() {
         //java中获取.class的三种方式
        // 1 类名.class
        // 2 对象.getClass()
        // 3 Class.forName("全类名")

        //kotlin中获取class的方式
        //一种是跟java中反射一样
        // 1 实例.javaClass
        var javaClass = InvokeTestClass().javaClass
        // 2 通过类KClass.java属性
        var javaClass2 = InvokeTestClass::class.java
        //另一个中是kotlin中独有的Kclass
        // 3 通过类：：class
        var kClass = InvokeTestClass::class
        // 4 实例.javaClass.kotlin
        var kClass2 = InvokeTestClass().javaClass.kotlin

        //获取类可以访问的所有函数和属性，包括继承自积累的，但是不包括构造器
        var members = kClass.members
        //获取类声明的所有函数
        var declaredMethods = javaClass.declaredMethods

        javaClass.declaredMethods


    }


}