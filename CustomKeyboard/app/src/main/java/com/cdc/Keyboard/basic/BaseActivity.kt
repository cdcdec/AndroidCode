package com.cdc.keyboard.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdc.keyboard.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    protected  fun <T> goToPage(cla:Class<T>){
        val intent = Intent(this, cla)
        startActivity(intent)
    }
}
