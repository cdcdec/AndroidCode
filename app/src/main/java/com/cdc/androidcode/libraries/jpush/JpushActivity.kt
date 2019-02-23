package com.cdc.androidcode.libraries.jpush
import com.cdc.androidcode.BaseActivity
import kotlinx.android.synthetic.main.activity_jpush.*
import com.cdc.androidcode.ExampleUtil
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.view.View
import cn.jpush.android.api.JPushInterface
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.toolbar_common.*


class JpushActivity : BaseActivity(){

    //for receive customer msg from jpush server
    private val mMessageReceiver: MessageReceiver? = null
    val MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"
    val KEY_TITLE = "title"
    val KEY_MESSAGE = "message"
    val KEY_EXTRAS = "extras"

    inner class MessageReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.action)) {
                    val messge = intent.getStringExtra(KEY_MESSAGE)
                    val extras = intent.getStringExtra(KEY_EXTRAS)
                    val showMsg = StringBuilder()
                    showMsg.append("$KEY_MESSAGE : $messge\n")
                    if (!ExampleUtil.isEmpty(extras)) {
                        showMsg.append("$KEY_EXTRAS : $extras\n")
                    }
                    setCostomMsg(showMsg.toString())
                }
            } catch (e: Exception) {
            }

        }
    }

    private fun setCostomMsg(msg:String) {
        if (null != msg_rec) {
            //msg_rec.text=
            msg_rec.visibility=android.view.View.VISIBLE
        }
    }
    override fun initView() {
        toolBarTitle.text="Jpush"
        setStatusBar()
        init.setOnClickListener(this)
        stopPush.setOnClickListener(this)
        resumePush.setOnClickListener(this)
        getRegistrationId.setOnClickListener(this)
        setting.setOnClickListener(this)

//        var udid=JpushUtil.getImei(applicationContext,"")
//        if(null != udid){
//            tv_imei.text="IMEI: $udid"
//        }
        var appKey=JpushUtil.getAppKey(applicationContext)
        if(appKey==null){
            tv_appkey.text= "AppKey异常"
        }else{
            tv_appkey.text="AppKey: $appKey"
        }
        tv_regId.text="RegId:"

        tv_package.text="PackageName: $packageName"
        tv_device_id.text="deviceId:"
        var versionName=JpushUtil.GetVersion(applicationContext)

        tv_version.text="Version: $versionName"
    }


    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_jpush
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        if (v != null) {
            when(v.id){
                R.id.init->{
                    JPushInterface.init(application)
                }
            }
        }
    }


}


/*
open class InstrumentedActivity : Activity() {

    override fun onStart() {
        super.onStart()
    }

    protected override fun onResume() {
        super.onResume()
        JPushInterface.onResume(this)
    }

    protected override fun onPause() {
        super.onPause()
        JPushInterface.onPause(this)
    }

    override fun onStop() {
        super.onStop()
    }
}
*/
