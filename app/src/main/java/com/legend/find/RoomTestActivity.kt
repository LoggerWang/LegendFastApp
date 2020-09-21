package com.legend.find

import android.animation.Animator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.legend.ArouterConst
import com.legend.R
import kotlinx.android.synthetic.main.activity_room_test.*

@Route(path = ArouterConst.ACTIVITY_ROOM_TEST)
class RoomTestActivity:AppCompatActivity(){

    var isOpen = false
    var lp : RelativeLayout.LayoutParams?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_test)
         lp = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
        lp!!.height = 200
        llBottom.layoutParams = lp
        llBottom.setOnClickListener {

            if (isOpen) {
                scrolltopos(500,200)
            }else{
                scrolltopos(200,500)
            }
        }
        llBottom.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_UP -> {
                    if (isOpen) {
                        scrolltopos(500,200)
                    }else{
                        scrolltopos(200,500)
                    }
                }
                else -> {
                }
            }
            true
        }
        var datas = arrayListOf<String>()
        datas.add("1")
        datas.add("2")
        datas.add("3")
        datas.add("4")
        datas.add("5")
        viewpager.adapter = MyAdpter(this, datas)
        viewpager.currentItem = 0
    }




    private fun scrolltopos( startV:Int, endV:Int) {

        var anim = ValueAnimator.ofObject(HeightEvaluater(), startV, endV)
        anim.duration = 300
//        anim.addUpdateListener {
//        }
        anim.addUpdateListener {
            val animatedValue = it.animatedValue as Int

            Log.d("ValueAnimator========","onAnimationUpdate$animatedValue")
//                layout(left, fl.toInt(), right,  (fl+height).toInt())
//                clickkable = true
            lp?.height = animatedValue


            llBottom.layoutParams = lp
        }

        anim.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }
            override fun onAnimationEnd(animation: Animator?) {

                isOpen = !isOpen
                Log.d("ValueAnimator========","onAnimationEnd$isOpen")}
            override fun onAnimationCancel(animation: Animator?) {
                Log.d("TAG", "onAnimationCancel====onAnimationCancel  " )
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })

        anim.start()
    }



    class MyAdpter(var context:Context,var datas:List<String>):PagerAdapter(){
        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view == obj
        }

        override fun getCount(): Int {
            return if (datas.isNullOrEmpty()) 0 else datas.size
        }

        var childCount = 0

//    private val bitmapCache: LruCache<String, Bitmap> = LruCache(10)

        override fun notifyDataSetChanged() {
            childCount = count
            super.notifyDataSetChanged()
        }
        override fun getItemPosition(obj: Any): Int {
//        if (!imageUrlList.isNullOrEmpty()) {
//            val sId: String = (obj as View).getTag(R.id.medrecord_img_tag) as String
//            if (sId.isNotEmpty()) {
//                return imageUrlList?.indexOfFirst { it.sId == sId } ?: POSITION_NONE
//            }
//        }
//        return POSITION_NONE

            if(childCount>0){
                childCount--
                return POSITION_NONE
            }

            return super.getItemPosition(obj)
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var img = ImageView(context)

            img.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT)
            img.setImageResource(R.drawable.ic_airport_shuttle_black_24dp)
//            img.text = datas[position]

            container.addView(img)
            return img
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            val count: Int = container.childCount
//        for (i in 0..count) {
//            val childView = container.getChildAt(i)
//            if (childView == obj) {
//                container.removeView(childView)
//                break
//            }
//        }
            container.removeView(obj as View)
        }

    }

    inner class HeightEvaluater:TypeEvaluator<Int>{
        override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int {
            return (startValue!! + fraction*(endValue!!- startValue)).toInt()
        }

    }


}