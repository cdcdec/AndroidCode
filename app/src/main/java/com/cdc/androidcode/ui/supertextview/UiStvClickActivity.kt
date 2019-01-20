package com.cdc.androidcode.ui.supertextview
import android.support.v7.widget.Toolbar
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_ui_stv_click.*

class UiStvClickActivity : BaseActivity() {
    override fun initView() {
        leftArrow(toolbarClick)

    }

    override fun initData() {

    }

    override fun layoutId(): Int {

        return R.layout.activity_ui_stv_click
    }


    private fun leftArrow(toolBar: Toolbar){
        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).init()
    }



}
