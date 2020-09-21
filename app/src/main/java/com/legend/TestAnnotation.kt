package com.legend

import androidx.annotation.IntDef
import com.legend.TestAnnotation.Companion.MAN
import com.legend.TestAnnotation.Companion.WOMAN




@IntDef(MAN, WOMAN)
@Target(AnnotationTarget.TYPE_PARAMETER,AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
annotation class TestAnnotation {
    companion object{
       const val MAN =0
        const val WOMAN =1
    }
}