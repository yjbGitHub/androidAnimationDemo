package com.puppy.android_animation_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.scale.*

/**
 * created by yujianbin on 2018/6/26
 *
 */
class ScaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scale)



        val Xanimation =  AnimationUtils.loadAnimation(this, R.anim.scale_x)
        Xanimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {}

            override fun onAnimationStart(p0: Animation?) {
                scale_activity_btn.visibility = View.VISIBLE
            }

        })

        x_scale.setOnClickListener {
            scale_activity_btn.startAnimation(Xanimation)
        }



        val Yanimation = AnimationUtils.loadAnimation(this, R.anim.scale_y)

        y_scale.setOnClickListener {
            scale_activity_btn.startAnimation(Yanimation)
        }


        val XYanimation = AnimationUtils.loadAnimation(this, R.anim.scale_xy)
        xy_scale.setOnClickListener {
            scale_activity_btn.startAnimation(XYanimation)
        }
    }
}