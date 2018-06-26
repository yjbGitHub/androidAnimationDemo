package com.puppy.android_animation_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.set_animation.*

/**
 * created by yujianbin on 2018/6/26
 *
 */
class SetAnimationActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_animation)


        val setAnimationA = AnimationUtils.loadAnimation(this, R.anim.set_animation_a)
        set_a.setOnClickListener {
            ani_view.startAnimation(setAnimationA)
        }

        setAnimationA.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {}

            override fun onAnimationStart(p0: Animation?) {
                ani_view.visibility = View.VISIBLE
            }
        })


        val setAnimationB = AnimationUtils.loadAnimation(this, R.anim.set_animation_b)
        set_b.setOnClickListener {
            ani_view.startAnimation(setAnimationB)
        }


        val setAnimationC = AnimationUtils.loadAnimation(this, R.anim.set_animation_c)
        set_c.setOnClickListener {
            ani_view.startAnimation(setAnimationC)
        }

    }
}