package com.legend.study

import android.app.Activity
import android.view.View
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation

class InjectViewUtilsKt {
    companion object {
        fun injectViewKt(activity: Activity) {
            var clz = activity::class.java
            var declaredFields = clz.declaredFields
            declaredFields.forEach {
                if (it.isAnnotationPresent(MyButterKnifeKt::class.java)) {
                    var annotation = it.getAnnotation(MyButterKnifeKt::class.java)
                    var id = annotation.value
                    var view = activity.findViewById<View>(id)
                    it.isAccessible = true

                    it.set(activity,view)
                }
            }
            /*      //返回类可访问的所有函数和属性，包括继承自基类的，但是不包括构造器
                    override val members: Collection<KCallable<*>>
                    //返回类声明的所有函数
                    val KClass<*>.declaredFunctions: Collection<KFunction<*>>
                    //返回类的扩展函数
                    val KClass<*>.declaredMemberExtensionFunctions: Collection<KFunction<*>>
                    //返回类的扩展属性
                    val <T : Any> KClass<T>.declaredMemberExtensionProperties: Collection<KProperty2<T, *, *>>
                    //返回类自身声明的成员函数
                    val KClass<*>.declaredMemberFunctions: Collection<KFunction<*>>
                    //返回类自身声明的成员变量（属性）
                    val <T : Any> KClass<T>.declaredMemberProperties: Collection<KProperty1<T, *>>*/

//            var declaredMemberProperties = kClass.declaredMemberProperties
//            declaredMemberProperties.forEach {
//                it.
//                var annotations = it.annotations
//                if (!annotations.isNullOrEmpty()) {
//                    if (annotations.contains(MyButterKnifeKt::class)) {
//                        annotations.forEach {
//
//                        }
//                    }
//                }
//            }

        }
    }
}