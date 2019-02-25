package com.cdc.androidcode.libraries.xxpermissions
import android.view.View
import android.widget.Toast
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.hjq.permissions.OnPermission
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import kotlinx.android.synthetic.main.activity_xxpermissions_main.*
import kotlinx.android.synthetic.main.toolbar_common.*

class XXPermissionsMainActivity : BaseActivity() {
    override fun initView() {
        toolBarTitle.text="XXPermissions"
        setStatusBar()
        btnRequestPer.setOnClickListener(this)
        btnIsHasPermission.setOnClickListener(this)
        btnPermissionSettings.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnRequestPer->{
                requestPermission()
            }
            R.id.btnIsHasPermission->{
                isHasPermission()
            }
            R.id.btnPermissionSettings->{
                gotoPermissionSettings()
            }
        }
    }

    private fun requestPermission(){
        XXPermissions.with(this) //.constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
            //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
            .permission(Permission.Group.STORAGE, Permission.Group.CONTACTS) //不指定权限则自动获取清单中的危险权限
            .request(object:OnPermission{
                override fun noPermission(denied: MutableList<String>?, quick: Boolean) {
                    if(quick) {
                        Toast.makeText(this@XXPermissionsMainActivity,"被永久拒绝授权，请手动授予权限",Toast.LENGTH_SHORT).show()
                        //如果是被永久拒绝就跳转到应用权限系统设置页面
                        XXPermissions.gotoPermissionSettings(this@XXPermissionsMainActivity)
                    }else {
                        Toast.makeText(this@XXPermissionsMainActivity,"获取权限失败",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun hasPermission(granted: MutableList<String>?, isAll: Boolean) {
                    if (isAll) {
                        Toast.makeText(this@XXPermissionsMainActivity,"获取权限成功",Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this@XXPermissionsMainActivity,"获取权限成功，部分权限未正常授予",Toast.LENGTH_SHORT).show()
                    }
                }

            })
    }

    private fun isHasPermission(){
        if (XXPermissions.isHasPermission(this@XXPermissionsMainActivity, Permission.Group.STORAGE)) {
            Toast.makeText(this@XXPermissionsMainActivity,"已经获取到权限，不需要再次申请了",Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this@XXPermissionsMainActivity,"还没有获取到权限或者部分权限未授予",Toast.LENGTH_SHORT).show()
        }
    }

    private fun gotoPermissionSettings(){
        XXPermissions.gotoPermissionSettings(this@XXPermissionsMainActivity)
    }

    override fun initData() {

    }

    override fun layoutId(): Int {

        return R.layout.activity_xxpermissions_main
    }



}
