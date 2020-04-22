package com.legend

import android.content.res.Resources

/**
 * @author wanglezhi
 * @date   2020/4/22 16:49
 * @discription
 */
fun getStatusBarHeight(resources:Resources):Int{
    var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return resources.getDimensionPixelSize(resourceId)
}