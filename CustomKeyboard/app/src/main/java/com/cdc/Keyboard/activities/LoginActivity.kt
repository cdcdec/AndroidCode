package com.cdc.keyboard.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cdc.keyboard.MainActivity
import com.cdc.keyboard.R
import com.cdc.keyboard.basic.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvLoginLable->{
                startActivity(Intent(this,MainActivity::class.java))
            }
            R.id.loginReRegisterTv->{
                startActivity(Intent(this,RegisteredActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView(){
        tvLoginLable.setOnClickListener(this)
        loginReRegisterTv.setOnClickListener(this)
    }



}
