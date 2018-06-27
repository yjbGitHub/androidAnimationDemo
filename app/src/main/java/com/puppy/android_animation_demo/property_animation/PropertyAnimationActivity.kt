package com.puppy.android_animation_demo.property_animation

import android.animation.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
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


        property_anim_btn.setOnClickListener {
            Toast.makeText(this@PropertyAnimationActivity, "点我干啥", Toast.LENGTH_SHORT).show()
        }

        transTV.setOnClickListener {
            translation()
        }

        rotateTV.setOnClickListener {
            rotation()
        }

        alphaTV.setOnClickListener {
            alpha()
        }

        scaleTV.setOnClickListener {
            scale()
        }

        animsetATV.setOnClickListener {
            animatorSetA()
        }

        animsetBTV.setOnClickListener {
            animatorSetB()
        }

    }




    fun scale(){

        //property取值为 'scaleX', 'scaleY'
        val animator = ObjectAnimator.ofFloat(property_anim_btn, "scaleX", 1f, 0f, 1f)
        animator.duration = 2000
        animator.interpolator = AccelerateInterpolator(2f);
        animator.repeatCount = -1
        animator.start()
    }


    fun translation(){
        //translationX：下个位置大于上个上个位置时，向右移动，反之向左移动；
        //translationY：下个位置大于上个上个位置时，向下移动，反之向上移动。

        //property 取值为 'translationX', 'translationY'
        val animator = ObjectAnimator.ofFloat(property_anim_btn, "translationX", 0f, -300f, 0F)
        animator.duration = 2000
        animator.repeatCount = -1
        animator.start()
    }

    fun rotation(){
        //下个度数大于上个度数，顺时针旋转；下个度数小于上个度数，逆时针旋转; 下面的代码意思是，先顺时针旋转360度，再逆时针旋转720度

        //property 取值为 'rotation'，'rotationX'，'rotationY'
        val animator = ObjectAnimator.ofFloat(property_anim_btn, "rotation", 0f,360f, -720f)
        animator.duration = 3000
        animator.repeatCount = -1
        animator.start()
    }


    fun alpha(){
        //后面可以传多个值，
        val animator = ObjectAnimator.ofFloat(property_anim_btn,"alpha", 1f, 0f, 1f/*, 0f, 1f,
         0f*/)
        //-1 代表一直重复
        animator.repeatCount = -1
        animator.duration = 2000
        animator.start()
    }

    /**
     * 动画集合，提供把多个动画组合成一个组合的机制，并可设置动画的时序关系，如同时播放、顺序播放或延迟播放。具体使用方法比较简单，
     */
    fun animatorSetA(){
        val a1 = ObjectAnimator.ofFloat(property_anim_btn, "alpha", 1.0f,0f, 1.0f)
        a1.repeatCount = -1

        val a2 = ObjectAnimator.ofFloat(property_anim_btn, "translationX", 0f, 300f, 0f)
        a2.repeatCount = -1

        val a3 = ObjectAnimator.ofFloat(property_anim_btn, "rotation", 0f, 360f, 0f)
        a3.repeatCount = -1

        val a4 = ObjectAnimator.ofFloat(property_anim_btn, "scaleX", 1f, 0f, 1f)
        a4.repeatCount = -1

        val a5 = ObjectAnimator.ofFloat(property_anim_btn, "scaleY", 1f, 0f, 1f)
        a5.repeatCount = -1


        val animSet = AnimatorSet()
        animSet.duration = 2000
        animSet.interpolator = LinearInterpolator()
        animSet.play(a1).with(a2).with(a3).with(a4).with(a5)
        animSet.start()

    }


    fun animatorSetB(){


        val a2 = ObjectAnimator.ofFloat(property_anim_btn, "translationX", 0f, 300f)

        val a3 = ObjectAnimator.ofFloat(property_anim_btn, "rotation", 0f, 360f)

        val a4 = ObjectAnimator.ofFloat(property_anim_btn, "scaleX", 1f, 0f)
        val a5 = ObjectAnimator.ofFloat(property_anim_btn, "scaleY", 1f, 0f)
        val a1 = ObjectAnimator.ofFloat(property_anim_btn, "alpha", 1f,0f)



        val animSet = AnimatorSet()
        animSet.duration = 2000

        //连在一起的多个afte会在一起执行
        animSet.play(a4).with(a5).with(a1).after(a2).after(a3)
        animSet.start()

        animSet.addListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                Toast.makeText(this@PropertyAnimationActivity, "动画完成", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationStart(p0: Animator?) {}

        })
    }

    /**
     * 多属性动画同时工作管理类。有时候我们需要同时修改多个属性，那就可以用到此类
     */
    fun propertyVlaues(){
        val a1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f)
        val a2 = PropertyValuesHolder.ofFloat("translationY", 0F, 400F)
//        val a3 = PropertyValuesHolder.ofFloat("rotationX", 55F, -30F, 15F, -15F, 0F)
        val a3 = PropertyValuesHolder.ofFloat("rotationX", 0.0F, 360F)
        ObjectAnimator.ofPropertyValuesHolder(property_anim_btn, a1, a2, a3)
                .setDuration(2000)
                .start()
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