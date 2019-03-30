package com.cdc.androidcode.libraries.immersionbar

import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.gyf.barlibrary.ImmersionBar

class TopIvImmerBarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        hasToolBar=false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_iv_immer_bar)
        initImmersionBar()
    }

    private fun initImmersionBar(){
        ImmersionBar.with(this)
            .statusBarView(R.id.top_view)
            .navigationBarColor(R.color.colorPrimary)
            .fullScreen(true)
            .addTag("PicAndColor")
            .barAlpha(1.0f)
            .init()
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy()
    }

}
