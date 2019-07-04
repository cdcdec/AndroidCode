package com.cdc.keyboard.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdc.keyboard.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
