package com.cdc.androidcode.libraries.jpush
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.toolbar_common.*

class PushingSettingActivity : BaseActivity() {
    override fun initView() {
        toolBarTitle.text="PushingSetting"
        setStatusBar()
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_pusing_setting
    }


}
