package com.cdc.androidcode.libraries.glide
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ActivityUtils
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.glide_main_activity.*

class GlideMainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Glide use")
        setContentView(R.layout.glide_main_activity)
        btn1.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn1->{
                ActivityUtils.startActivity(GlideOneActivity::class.java)
            }
        }
    }








}
