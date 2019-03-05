package com.cdc.androidcode.ui.supertextview
import androidx.appcompat.widget.Toolbar
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_ui_stv_super_button.*

class UiStvSuperButtonActivity : BaseActivity() {
    override fun initView() {
        leftArrow(toolbarSuButton)
    }

    override fun initData() {

    }

    override fun layoutId(): Int {

        return R.layout.activity_ui_stv_super_button
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
