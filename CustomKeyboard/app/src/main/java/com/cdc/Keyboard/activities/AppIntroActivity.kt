package com.cdc.keyboard.activities

import android.os.Bundle
import com.cdc.keyboard.R
import com.cdc.keyboard.basic.RootActivity

class AppIntroActivity : RootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_intro)
    }
}
