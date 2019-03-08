package com.cdc.androidcode.ui.supertextview
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class UiStvCommonActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ui_stv_common")
        setContentView(R.layout.activity_ui_stv_common)
    }



}
