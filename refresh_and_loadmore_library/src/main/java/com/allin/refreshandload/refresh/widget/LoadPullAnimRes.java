package com.allin.refreshandload.refresh.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import com.allin.refreshandload.R;

/**
 * Description:下拉动画加载类
 *
 * @author: guoyongping
 * @date: 2016/4/7 18:20
 */
public class LoadPullAnimRes {

    private static AnimationDrawable dropDownLoadingAnimDrawable;


    public static AnimationDrawable getDropDownLoadingAnimDrawable(Context context) {
        if (dropDownLoadingAnimDrawable == null) {
            dropDownLoadingAnimDrawable = new AnimationDrawable();
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_01), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_02), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_03), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_04), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_05), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_06), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_07), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_08), 120);
            dropDownLoadingAnimDrawable.addFrame(AppCompatResources.getDrawable(context, R.drawable.refreshing_09), 120);
            dropDownLoadingAnimDrawable.setOneShot(false);
        }
        return dropDownLoadingAnimDrawable;
    }
}
