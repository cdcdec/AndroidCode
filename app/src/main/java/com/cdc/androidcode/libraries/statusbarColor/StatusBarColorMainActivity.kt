package com.cdc.androidcode.libraries.statusbarColor

import android.os.Build
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_status_bar_color_main.*

class StatusBarColorMainActivity : AppCompatActivity() {

    private var mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA

    private var mStatusBarColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar_color_main)
        setSupportActionBar(statusBarColorToolBar)
        setStatusBar()

        setToggle()
        initView()


    }

    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            mStatusBarColor=resources.getColor(R.color.colorPrimary)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mStatusBarColor=resources.getColor(R.color.colorPrimary, null)
        }
        StatusBarUtil.setColorForDrawerLayout(
            this,
            statusBarColorDrawerLayout,
            mStatusBarColor,
            mAlpha
        )
    }

    private fun setToggle() {
        var toggle = ActionBarDrawerToggle(
            this, statusBarColorDrawerLayout, statusBarColorToolBar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        statusBarColorDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    private fun initView(){
        chb_translucent.setOnClickListener {
            if(chb_translucent.isChecked){
                statusBarColorMain.background = resources.getDrawable(R.drawable.bg_monkey)
                StatusBarUtil.setTranslucentForDrawerLayout(this@StatusBarColorMainActivity, statusBarColorDrawerLayout, mAlpha)
                statusBarColorToolBar.setBackgroundColor(resources.getColor(android.R.color.transparent))
            }else{
                statusBarColorMain.setBackgroundDrawable(null)
                statusBarColorToolBar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                StatusBarUtil.setColorForDrawerLayout(
                    this@StatusBarColorMainActivity, statusBarColorDrawerLayout,
                    resources.getColor(R.color.colorPrimary), mAlpha
                )
            }
        }

        sb_change_alpha.max=255
        sb_change_alpha.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mAlpha = progress
                if (chb_translucent.isChecked) {
                    StatusBarUtil.setTranslucentForDrawerLayout(this@StatusBarColorMainActivity, statusBarColorDrawerLayout, mAlpha)
                } else {
                    StatusBarUtil.setColorForDrawerLayout(this@StatusBarColorMainActivity, statusBarColorDrawerLayout, mStatusBarColor, mAlpha)
                }
                tv_status_alpha.text = mAlpha.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        sb_change_alpha.progress=StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA

    }


}
