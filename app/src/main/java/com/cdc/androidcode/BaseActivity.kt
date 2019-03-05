package com.cdc.androidcode
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import com.cdc.androidcode.application.RudenessScreenHelper
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.toolbar_common.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)15:27
 * updateDesc:(修改内容)
 */
abstract class BaseActivity: AppCompatActivity(), OnClickListener{

    override fun onClick(v: View?) {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //无法隐藏标题栏
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(layoutId())
        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar()
        }
        initView()
        initData()
    }


    abstract fun initView()
    abstract fun initData()
    abstract fun layoutId(): Int

    protected open fun initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).init()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (isImmersionBarEnabled()) {
            // 非必加
            // 如果你的app可以横竖屏切换，适配了4.4或者华为emui3.1系统手机，并且navigationBarWithKitkatEnable为true，
            // 请务必在onConfigurationChanged方法里添加如下代码（同时满足这三个条件才需要加上代码哦：1、横竖屏可以切换；2、android4.4或者华为emui3.1系统手机；3、navigationBarWithKitkatEnable为true）
            // 否则请忽略
            //ImmersionBar.with(this).init()
        }
        RudenessScreenHelper.resetDensity(this@BaseActivity, 750.00f)
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy() //必须调用该方法，防止内存泄漏
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     * true  可以使用   false:不使用
     * 子类重写此方法进行控制
     *
     * @return the boolean
     */
    protected open fun isImmersionBarEnabled():Boolean {
        return true
    }

     fun setStatusBar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }






}