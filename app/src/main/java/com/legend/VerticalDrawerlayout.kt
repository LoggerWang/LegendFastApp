package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.View
import android.view.ViewTreeObserver
import android.widget.*
import com.legend.R
import com.legend.ScreenUtils
import com.legend.getStatusBarHeight

/**
 * @author wanglezhi
 * @date   2020/5/12 11:37
 * @discription
 */
class VerticalDrawerlayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr)  {

    var ivSwitch:ImageView?=null
    var isDraging = false

    var MIN_HEIGHT = 125
    var MAX_HEIGHT = 375
    var lp:RelativeLayout.LayoutParams?=null

    var downY=0
    var downRawY=0
    var moveRawY=0
    var upY=0
    var moveY=0
    var screenWidth=0
    var screenHeight=0
    var topY=0
    var newTopY=0
    var distance = 0
    var statusHeight = 0


    private var bottomtop = 0
    private var bottombot = 0
    private var maxBottom = 0
    var mIsUpdate = true


    init {
        View.inflate(context, R.layout.drawerlayout, this)
        ivSwitch = findViewById<ImageView>(R.id.ivSwitch)
        lp = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
//        lp?.height = MIN_HEIGHT
//
//        layoutParams = lp
//        invalidate()

        viewTreeObserver.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                if (mIsUpdate) {
                    mIsUpdate = false
                    bottomtop = top
                    bottombot = bottom
                    maxBottom = bottom
                    screenHeight = ScreenUtils.getScreenHeight(context)
                    statusHeight = ScreenUtils.getStatusBarHeight(context)
                    screenHeight -=statusHeight
                }
            }

        })



    }


    private var lastX = 0f
    private var lastY = 0f
    private var mleft = 0
    private var mtop = 0
    private var mright = 0
    private var mbottom = 0

    private val MINHRIGHT = 200
    private val mTitleView: TextView? = null
    private val mContentView: TextView? = null


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }


    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {

        when (event!!.action) {
            ACTION_DOWN -> {
                lastX = event.rawX
                lastY = event.rawY

                Log.d("TAG", "ACTION_DOWN====lastY$lastY  " )
            }
            MotionEvent.ACTION_MOVE -> {
                //移动的距离
                val distanceX: Float = event.rawX - lastX
                val distanceY: Float = event.rawY - lastY
                Log.d("TAG", "event.rawY${event.rawY} ==distanceY====distanceY$distanceY  " )
                //移动后控件的坐标
                mleft = (left + distanceX).toInt()
                mtop = (top + distanceY).toInt()
                mright = (right + distanceX).toInt()
                mbottom = (bottom + distanceY).toInt()
                //处理拖出屏幕的情况
                if (mleft < 0) {
                    mleft = 0
                    mright = width
                }
                if (mright > screenWidth) {
                    mright = screenWidth
                    mleft = screenWidth - width
                }
//                if (mtop < 0) {
//                    mtop = 0
//                    mbottom = height
//                }
//                if (bottom > bottombot) {
//                    bottom = bottombot
//                    mtop = bottombot - height
//                }
//                if (mbottom < maxBottom) {
//                    mbottom = maxBottom
//                    mtop = maxBottom - height
//                }

                if(mbottom<screenHeight){
                    mbottom=screenHeight
                    mtop=screenHeight-height
                }
                if(mtop<screenHeight-height){
                    mbottom=screenHeight
                    mtop=screenHeight-height
                }

                if (mbottom>bottombot){
                    mbottom=bottombot
                    mtop=bottombot-height
                }


                //移动View
                layout(left, mtop, right, mbottom)
//                invalidate()
                Log.d("TAG", "====mlefg$left =====mtop$mtop =====mright$right =====mbottom$mbottom" )
                lastX = event.rawX
                lastY = event.rawY
            }
            MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL -> {
            }
        }
        return true
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }


}