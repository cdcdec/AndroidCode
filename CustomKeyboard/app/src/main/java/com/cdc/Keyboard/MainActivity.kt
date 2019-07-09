package com.cdc.keyboard

import android.os.Bundle
import android.view.View
import com.cdc.keyboard.activities.SettingActivity
import com.cdc.keyboard.activities.TakeawayActivity
import com.cdc.keyboard.basic.RootActivity
import com.cdc.keyboard.ui.dialog.DialogRoot
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewNoTitle(R.layout.activity_main)

        //外卖
        takeawayIdTv.setOnClickListener(View.OnClickListener {
            goToPage(TakeawayActivity::class.java)
        })
        //更多
        moreButtonParent.setOnClickListener(View.OnClickListener {
            DialogRoot(this,R.layout.pos_main_more_10500).show()


        })
    }
    //设置按钮
    fun settingsIdTvClick(v:View){
        goToPage(SettingActivity::class.java)
    }
}
