package com.cdc.androidcode.libraries.glide
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class GlideMainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Glide use")
        setContentView(R.layout.glide_main_activity)
    }



    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn1->{
                var intent= Intent()
                intent.setClass(this@GlideMainActivity,GlideOneActivity::class.java)
                startActivity(intent)
            }
        }
    }








}
