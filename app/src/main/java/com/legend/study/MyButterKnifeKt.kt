package com.legend.study

import java.lang.RuntimeException

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyButterKnifeKt(val value:Int)
