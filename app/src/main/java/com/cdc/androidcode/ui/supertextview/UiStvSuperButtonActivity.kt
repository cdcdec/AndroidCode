package com.cdc.androidcode.ui.supertextview
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.gyf.barlibrary.ImmersionBar

class UiStvSuperButtonActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ui_stv_super_button")
        setContentView(R.layout.activity_ui_stv_super_button)
    }



    private fun leftArrow(toolBar: Toolbar){
        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }




}
