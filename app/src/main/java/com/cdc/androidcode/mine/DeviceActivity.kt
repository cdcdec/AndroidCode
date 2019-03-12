package com.cdc.androidcode.mine
import android.os.Bundle
import com.blankj.utilcode.util.DeviceUtils
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
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
        //android 版本号
        tvVersion.text=tvVersion.text.toString()+":"+ DeviceUtils.getSDKVersionName()
        //android api
        tvVersionSdk.text=tvVersionSdk.text.toString()+":"+ DeviceUtils.getSDKVersionCode()
        //android id
        tvAndroidId.text=tvAndroidId.text.toString()+":"+DeviceUtils.getAndroidID()


        //mac地址
        tvMacAds.text=tvMacAds.text.toString()+":"+DeviceUtils.getMacAddress()
        //制造商
        tvManufacturer.text=tvManufacturer.text.toString()+":"+DeviceUtils.getManufacturer()

        //model
        tvModel.text=tvModel.text.toString()+":"+DeviceUtils.getModel()
        //是否root
        tvRoot.text=tvRoot.text.toString()+":"+DeviceUtils.isDeviceRooted()










    }
}
