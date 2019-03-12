package com.cdc.androidcode.mine
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.AppUtils
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("应用信息")
        setContentView(R.layout.activity_app)
        init()
    }

    private fun init(){
        tvAppName.text=setTvNameBefore(tvAppName)+ AppUtils.getAppName()
        tvPkgName.text=setTvNameBefore(tvPkgName)+AppUtils.getAppPackageName()
        tvAppPath.text=setTvNameBefore(tvAppPath)+AppUtils.getAppPath()
        tvAppMD5.text=setTvNameBefore(tvAppMD5)+AppUtils.getAppSignatureMD5()
        tvAppSHA1.text=setTvNameBefore(tvAppSHA1)+AppUtils.getAppSignatureSHA1()
        tvAppSHA256.text=setTvNameBefore(tvAppSHA256)+AppUtils.getAppSignatureSHA256()
        tvAppVersionCode.text=setTvNameBefore(tvAppVersionCode)+AppUtils.getAppVersionCode()
        tvAppVersionName.text=setTvNameBefore(tvAppVersionName)+AppUtils.getAppVersionName()
        tvIsAppDebug.text=setTvNameBefore(tvIsAppDebug)+AppUtils.isAppDebug()
        tvIsAppSystem.text=setTvNameBefore(tvIsAppSystem)+AppUtils.isAppSystem()

        btnRelaunchApp.setOnClickListener(this)
        btnLaunchAppDetailsSettings.setOnClickListener(this)
        btnExitApp.setOnClickListener(this)

    }

    private fun setTvNameBefore(textView: TextView):String{
        return "${textView.text}:"
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view!!.id){
            R.id.btnRelaunchApp->{
                AppUtils.relaunchApp()
            }
            R.id.btnLaunchAppDetailsSettings->{
                AppUtils.launchAppDetailsSettings()
            }
            R.id.btnExitApp->{
                AppUtils.exitApp()
            }
        }
    }
}
