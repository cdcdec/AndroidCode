package com.cdc.keyboard.activities

import android.os.Bundle
import android.view.View
import com.cdc.keyboard.R
import com.cdc.keyboard.basic.RootActivity
import kotlinx.android.synthetic.main.activity_registered.*

class RegisteredActivity : RootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewNoTitle(R.layout.activity_registered)
        registerBackIv.setOnClickListener(View.OnClickListener {
            finish()
        })

        registerTvTitle.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
