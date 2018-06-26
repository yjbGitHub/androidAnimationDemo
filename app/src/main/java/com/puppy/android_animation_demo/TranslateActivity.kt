package com.puppy.android_animation_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.translate.*

/**
 * created by yujianbin on 2018/6/26
 *
 */
class TranslateActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.translate)

        trans()
    }


    fun trans(){
        //
        val fromTop =  AnimationUtils.loadAnimation(this, R.anim.trans_from_top)
        fromTopTV.setOnClickListener{

            trans_button.startAnimation(fromTop)

        }

        //动画事件监听
        fromTop.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationEnd(p0: Animation?) {
                trans_button.clearAnimation()
            }

            override fun onAnimationStart(p0: Animation?) {
                trans_button.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })


        val fromBottom = AnimationUtils.loadAnimation(this, R.anim.trans_from_bottom)
        fromBottomTV.setOnClickListener{
            trans_button.startAnimation(fromBottom)
        }


        val fromRight = AnimationUtils.loadAnimation(this, R.anim.trans_from_right)
        fromRightTV.setOnClickListener{
            trans_button.startAnimation(fromRight)
        }


        val fromLeft = AnimationUtils.loadAnimation(this, R.anim.trans_from_left)
        fromLeftTV.setOnClickListener{
            trans_button.startAnimation(fromLeft)
        }

        //        抖动
        val leftRightShake = AnimationUtils.loadAnimation(this, R.anim.trans_left_right_shake)

        leftRightShakeTV.setOnClickListener {
            trans_button.startAnimation(leftRightShake)
        }

        val topBottomShake = AnimationUtils.loadAnimation(this, R.anim.trans_top_bottom_shake)
        topBottomShakeTV.setOnClickListener {
            trans_button.startAnimation(topBottomShake)
        }
    }
}