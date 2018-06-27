package com.puppy.android_animation_demo.property_animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.puppy.android_animation_demo.R
import kotlinx.android.synthetic.main.property_animation.*

/**
 * created by yujianbin on 2018/6/26
 *
 */
class PropertyAnimationActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.property_animation)



        topTV.setOnClickListener {
//            valutAnimator()
            objectAnimator()
        }
    }


    fun objectAnimator(){
        val objectAnimator = ObjectAnimator.ofInt(property_anim_btn, "width",property_anim_btn
                .layoutParams.width,600)
        objectAnimator.duration = 1000
        objectAnimator.start()
    }

    fun valutAnimator(){
        val valueAnimator = ValueAnimator.ofInt(property_anim_btn.layoutParams.width, 600)
        valueAnimator.duration = 2000

        valueAnimator.addUpdateListener {

            //获得每次变化后的属性值
            val currentValue = it.animatedValue


            //将每次变化的值手动赋值给对象的属性
            property_anim_btn.layoutParams.width = currentValue as Int

            //刷新视图
            property_anim_btn.requestLayout()
        }

        //启动动画
        valueAnimator.start()
    }
}