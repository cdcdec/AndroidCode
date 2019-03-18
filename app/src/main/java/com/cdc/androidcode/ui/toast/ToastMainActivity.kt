package com.cdc.androidcode.ui.toast
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class ToastMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Toast")
        setContentView(R.layout.activity_toast_main)


    }
}
