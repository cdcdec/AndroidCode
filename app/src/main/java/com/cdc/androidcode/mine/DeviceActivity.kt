package com.cdc.androidcode.mine
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.utils.DeviceUtils
import kotlinx.android.synthetic.main.activity_device.*

class DeviceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("我的设备")
        setContentView(R.layout.activity_device)
        init()
    }

    private fun init(){
        tvVersion.text=tvVersion.text.toString()+":"+ DeviceUtils.getSDKVersionName()
        tvVersionSdk.text=tvVersionSdk.text.toString()+":"+ DeviceUtils.getSDKVersionCode()
    }
}
