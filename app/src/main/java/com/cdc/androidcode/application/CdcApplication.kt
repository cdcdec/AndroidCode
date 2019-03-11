package com.cdc.androidcode.application

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import cn.jpush.android.api.JPushInterface
import com.cdc.androidcode.R
import com.chad.baserecyclerviewadapterhelper.util.Utils
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader


/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)13:30
 * updateDesc:(修改内容)
 */
class CdcApplication: MultiDexApplication() {



    //static 代码段可以防止内存泄露
    init {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)//全局设置主题颜色
            ClassicsHeader(context)
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            //指定为经典Footer，默认是 BallPulseFooter
            ClassicsFooter(context).setDrawableSize(20.toFloat())
        }


    }

    companion object {
        var appContext: CdcApplication? = null

        fun getInstance(): CdcApplication? {
            return appContext
        }
    }



    override fun onCreate() {
        super.onCreate()
        appContext = this
        Utils.init(this)
        com.cdc.utils.Utils.init(this)
        AutoSizeUtil().init(this)
        //RudenessScreenHelper(this, 750f).activate() //初始化百分比布局
        JPushInterface.setDebugMode(true)    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this)            // 初始化 JPush
    }


}