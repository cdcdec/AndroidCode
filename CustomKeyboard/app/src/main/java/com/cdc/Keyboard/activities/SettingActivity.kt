package com.cdc.keyboard.activities

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.RelativeLayout
import com.cdc.keyboard.R
import com.cdc.keyboard.basic.RootActivity
import com.cdc.keyboard.ui.dialog.DialogRoot
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : RootActivity() {

    private var permissionPopupWindow: PopupWindow? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewNoTitle(R.layout.activity_setting)
        initView()


    }

    private fun initView(){
        leftScroll.isVerticalScrollBarEnabled = false
        settingTopRightLin.setOnClickListener(View.OnClickListener {
            getPermissionPopupWindow()
            permissionPopupWindow!!.showAsDropDown(settingTopRightLin)
        })

    }

    override fun closeActivity(v: View){
        finish()
    }

    private fun getPermissionPopupWindow(): PopupWindow {
        val rootPopupWindow = View.inflate(this, R.layout.pos_setting_permission, null)
        this.permissionPopupWindow = PopupWindow(rootPopupWindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        this.permissionPopupWindow!!.setBackgroundDrawable(ColorDrawable())
        this.permissionPopupWindow!!.isOutsideTouchable = true
        //店铺信息
        rootPopupWindow.findViewById<RelativeLayout>(R.id.shopInfoRel).setOnClickListener(View.OnClickListener {
            goToPage(ShopInfoSettingsActivity::class.java)
        })

        //员工管理
        rootPopupWindow.findViewById<RelativeLayout>(R.id.userManagementRel).setOnClickListener(View.OnClickListener {
            goToPage(UserManagementActivity::class.java)
        })

        //修改密码
        rootPopupWindow.findViewById<RelativeLayout>(R.id.changePwdRel).setOnClickListener(View.OnClickListener {
            DialogRoot(this,R.layout.pos_um_modify_password_dialog).show()
        })

        //同步并退出
        rootPopupWindow.findViewById<RelativeLayout>(R.id.syncBackRel).setOnClickListener(View.OnClickListener {

        })
        return this.permissionPopupWindow!!

    }
}
