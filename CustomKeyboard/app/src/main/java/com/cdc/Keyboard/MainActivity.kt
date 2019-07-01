package com.cdc.Keyboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.cdc.screen.ScreenUtil
import com.cdc.test1.Test1Activity
import com.cdc.test2.Test2Activity
import com.cdc.test3.Test3Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn1 -> {
                goToPage(Test1Activity::class.java)
            }
            R.id.btn2 -> {
                goToPage(Test2Activity::class.java)
            }
            R.id.btn3 -> {
                goToPage(Test3Activity::class.java)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)

        val screenUtil=ScreenUtil()
        val screenStr=screenUtil.screen(this).toString()
        //density:1.3312501, densityDpi:213, widthPixels:1280, heightPixels:736, widthDpi:962.0023, heightDpi:553.36383, orientation:"横屏", systemVersion:"6.0.1", systemModel:"S1", deviceBrand:"Allwinner", facturer:"Allwinner", product:"tulip_zf101s", sdkLevel:23}
        Log.e("123",screenStr)
    }

    private fun <T> goToPage(cls: Class<T>) {
        var intent = Intent(this, cls)
        startActivity(intent)
    }
}
