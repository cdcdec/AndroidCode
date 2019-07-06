package com.cdc.keyboard

import android.os.Bundle
import android.view.View
import com.cdc.keyboard.R
import com.cdc.keyboard.activities.SettingActivity
import com.cdc.keyboard.basic.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //设置按钮
    fun settingsIdTvClick(v:View){
        goToPage(SettingActivity::class.java)
    }
}
