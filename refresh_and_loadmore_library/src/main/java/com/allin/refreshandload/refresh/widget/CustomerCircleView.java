package com.allin.refreshandload.refresh.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:绘制空心圆形
 *
 * @author guoyongping
 * @date 2018/10/25 14:43
 */
public class CustomerCircleView extends View {

    /** 圆环颜色 */
    private int mColor = Color.parseColor("#6483E9");
    /** 画笔 */
    private Paint mPaint;
    /** 圆弧的度数 */
    private int mProgress;

    public CustomerCircleView(Context context) {
        this(context, null);
    }

    public CustomerCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int center = getWidth() / 2;
        // 圆弧的宽度
        int mCircleWidth = 4;
        // 半径
        int radius = center - mCircleWidth / 2;
        // 设置圆环的宽度
        mPaint.setStrokeWidth(mCircleWidth);
        // 消除锯齿
        mPaint.setAntiAlias(true);
        // 设置空心
        mPaint.setStyle(Paint.Style.STROKE);
        // 用于定义的圆弧的形状和大小的界限
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);
        // 设置圆环的颜色
        mPaint.setColor(mColor);
        // 根据进度画圆弧
        canvas.drawArc(oval, -90, mProgress, false, mPaint);
    }

    public void start(int progress) {
        this.mProgress = progress;
    }

}
