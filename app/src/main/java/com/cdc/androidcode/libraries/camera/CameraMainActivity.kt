package com.cdc.androidcode.libraries.camera

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_camera_main.*

class CameraMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Camera")
        setContentView(R.layout.activity_camera_main)

        initView()
    }

    private fun initView() {
        camera1.setOnClickListener(this)
        camera2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        if (view != null) {
            var intent= Intent()
            when(view.id){
                R.id.camera1->{
                    intent.setClass(this@CameraMainActivity,Camera1Activity::class.java)
                    startActivity(intent)
                }

                R.id.camera2->{

                }

            }
            }
        }

}
