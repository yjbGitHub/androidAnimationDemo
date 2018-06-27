package com.puppy.android_animation_demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.puppy.android_animation_demo.property_animation.PropertyAnimationActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        translate_btn.setOnClickListener {
            val intent = Intent(this, TranslateActivity::class.java)
            startActivity(intent)
        }


        scale_btn.setOnClickListener {
            val intent = Intent(this, ScaleActivity::class.java)
            startActivity(intent)
        }

        rotate_btn.setOnClickListener {
            val intent = Intent(this, RotateActivity::class.java)
            startActivity(intent)
        }

        set_btn.setOnClickListener {
            val intent = Intent(this, SetAnimationActivity::class.java)
            startActivity(intent)
        }

        property_anim_btn.setOnClickListener {
            val intent = Intent(this, PropertyAnimationActivity::class.java)
            startActivity(intent)
        }

    }
}
