package com.cdc.androidcode.libraries.glide
import android.content.Intent
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.glide_main_activity.*
import kotlinx.android.synthetic.main.toolbar_common.*


class GlideMainActivity : BaseActivity() {


    override fun initView() {
        toolBarTitle.text="glide"
        setStatusBar()
        btn1.setOnClickListener(this)
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

    override fun initData() {

    }

    override fun layoutId(): Int {

        return R.layout.glide_main_activity
    }


}
