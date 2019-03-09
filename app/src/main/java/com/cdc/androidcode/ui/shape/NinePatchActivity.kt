package com.cdc.androidcode.ui.shape
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class NinePatchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("nine png")
        setContentView(R.layout.activity_nine_patch)
    }
}
