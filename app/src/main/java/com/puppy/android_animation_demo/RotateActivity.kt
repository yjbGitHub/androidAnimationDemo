package com.puppy.android_animation_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.rotate.*

/**
 * created by yujianbin on 2018/6/26
 *
 */
class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rotate)

        val rotateSAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_s)
        s_rotate.setOnClickListener {
            rotate_activity_btn.startAnimation(rotateSAnimation)
        }


        val rotateNAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_n)
        n_rotate.setOnClickListener {
            rotate_activity_btn.startAnimation(rotateNAnimation)
        }
    }
}