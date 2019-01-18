package com.cdc.androidcode.application

import android.app.Application
import com.scwang.smartrefresh.layout.SmartRefreshLayout

import android.content.Context
import com.cdc.androidcode.R
import com.scwang.smartrefresh.layout.SmartRefreshLayout.setDefaultRefreshHeaderCreator
import com.scwang.smartrefresh.layout.api.*
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
class CdcApplication:Application() {
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

    override fun onCreate() {
        super.onCreate()
        RudenessScreenHelper(this, 750f).activate() //初始化百分比布局
    }
}